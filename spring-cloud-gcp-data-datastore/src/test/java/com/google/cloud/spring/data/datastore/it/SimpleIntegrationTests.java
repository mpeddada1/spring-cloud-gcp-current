package com.google.cloud.spring.data.datastore.it;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import com.google.cloud.spring.data.datastore.entities.Product;
import com.google.cloud.spring.data.datastore.entities.ServiceConfiguration;
import com.google.cloud.spring.data.datastore.entities.Store;
import com.google.cloud.spring.data.datastore.it.TestEntity.Shape;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@EnabledIfSystemProperty(named = "it.datastore", matches = "true")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DatastoreIntegrationTestConfiguration.class})
public class SimpleIntegrationTests {

  @Autowired
  private TestEntityRepository testEntityRepository;
  private final TestEntity testEntityA = new TestEntity(1L, "red", 1L, Shape.CIRCLE, null);

  private final TestEntity testEntityB = new TestEntity(2L, "blue", 2L, Shape.CIRCLE, null);

  private final TestEntity testEntityC =
      new TestEntity(3L, "red", 1L, Shape.CIRCLE, null, new EmbeddedEntity("c"));

  private final TestEntity testEntityD =
      new TestEntity(4L, "red", 1L, Shape.SQUARE, null, new EmbeddedEntity("d"));

  private final List<TestEntity> allTestEntities =
      Arrays.asList(this.testEntityA, this.testEntityB, this.testEntityC, this.testEntityD);
  @AfterEach
  void deleteAll() {
    this.testEntityRepository.deleteAll();
  }

  @BeforeEach
  void saveEntities() {
    this.testEntityRepository.saveAll(this.allTestEntities);
    await()
        .atMost(20, TimeUnit.SECONDS)
        .untilAsserted(() -> assertThat(this.testEntityRepository.countBySize(1L)).isEqualTo(3));
  }

  @Test
  void testCounting() {
    assertThat(this.testEntityRepository.countBySizeAndColor(2, "blue")).isEqualTo(1);
    assertThat(this.testEntityRepository.getBySize(2L).getColor()).isEqualTo("blue");
    assertThat(this.testEntityRepository.countBySizeAndColor(1, "red")).isEqualTo(3);
    assertThat(
        this.testEntityRepository.findTop3BySizeAndColor(1, "red").stream()
            .map(TestEntity::getId)
            .collect(Collectors.toList()))
        .containsExactlyInAnyOrder(1L, 3L, 4L);
  }
}
