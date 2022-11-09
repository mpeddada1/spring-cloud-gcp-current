/*
 * Copyright 2022-2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.LanguageServiceSettings;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import java.io.IOException;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link LanguageServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by gapic-generator-java")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@ConditionalOnClass(LanguageServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.language.v1.spring.auto.language-service.enabled",
    matchIfMissing = false)
@EnableConfigurationProperties(LanguageServiceSpringProperties.class)
public class LanguageServiceSpringAutoConfiguration {
  private final LanguageServiceSpringProperties clientProperties;
  private static final Log LOGGER = LogFactory.getLog(LanguageServiceSpringAutoConfiguration.class);

  protected LanguageServiceSpringAutoConfiguration(
      LanguageServiceSpringProperties clientProperties) {
    this.clientProperties = clientProperties;
  }

  /**
   * Obtains the default credentials provider. The used key will be obtained from Spring Boot
   * configuration data files.
   */
  @Bean
  @ConditionalOnMissingBean
  public CredentialsProvider languageServiceCredentials() throws IOException {
    return ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultLanguageServiceTransportChannelProvider() {
    return LanguageServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a LanguageServiceClient bean configured to use the default credentials provider
   * (obtained with languageServiceCredentials()) and its default transport channel provider
   * (defaultLanguageServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in LanguageServiceProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public LanguageServiceClient languageServiceClient(
      @Qualifier("languageServiceCredentials") CredentialsProvider credentialsProvider,
      @Qualifier("defaultLanguageServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    LanguageServiceSettings.Builder clientSettingsBuilder =
        LanguageServiceSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider);
    // .setHeaderProvider();
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      LOGGER.info(
          "Quota project id set to "
              + this.clientProperties.getQuotaProjectId()
              + ", this overrides project id from credentials.");
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          LanguageServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      LOGGER.info(
          "Background executor thread count is " + this.clientProperties.getExecutorThreadCount());
    }
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder.setTransportChannelProvider(
          LanguageServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      LOGGER.info("Using HTTP transport channel");
    }
    RetrySettings.Builder analyzeSentimentRetrySettingBuilder =
        clientSettingsBuilder.analyzeSentimentSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAnalyzeSentimentInitialRetryDelay() != null) {
      analyzeSentimentRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAnalyzeSentimentInitialRetryDelay());
      LOGGER.info(
          "AnalyzeSentimentInitialRetryDelay set to "
              + this.clientProperties.getAnalyzeSentimentInitialRetryDelay());
    }
    if (this.clientProperties.getAnalyzeSentimentRetryDelayMultiplier() != null) {
      analyzeSentimentRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAnalyzeSentimentRetryDelayMultiplier());
      LOGGER.info(
          "AnalyzeSentimentRetryDelayMultiplier set to "
              + this.clientProperties.getAnalyzeSentimentRetryDelayMultiplier());
    }
    if (this.clientProperties.getAnalyzeSentimentMaxRetryDelay() != null) {
      analyzeSentimentRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAnalyzeSentimentMaxRetryDelay());
      LOGGER.info(
          "AnalyzeSentimentMaxRetryDelay set to "
              + this.clientProperties.getAnalyzeSentimentMaxRetryDelay());
    }
    if (this.clientProperties.getAnalyzeSentimentInitialRpcTimeout() != null) {
      analyzeSentimentRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAnalyzeSentimentInitialRpcTimeout());
      LOGGER.info(
          "AnalyzeSentimentInitialRpcTimeout set to "
              + this.clientProperties.getAnalyzeSentimentInitialRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeSentimentRpcTimeoutMultiplier() != null) {
      analyzeSentimentRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAnalyzeSentimentRpcTimeoutMultiplier());
      LOGGER.info(
          "AnalyzeSentimentRpcTimeoutMultiplier set to "
              + this.clientProperties.getAnalyzeSentimentRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getAnalyzeSentimentMaxRpcTimeout() != null) {
      analyzeSentimentRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAnalyzeSentimentMaxRpcTimeout());
      LOGGER.info(
          "AnalyzeSentimentMaxRpcTimeout set to "
              + this.clientProperties.getAnalyzeSentimentMaxRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeSentimentTotalTimeout() != null) {
      analyzeSentimentRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAnalyzeSentimentTotalTimeout());
      LOGGER.info(
          "AnalyzeSentimentTotalTimeout set to "
              + this.clientProperties.getAnalyzeSentimentTotalTimeout());
    }
    clientSettingsBuilder
        .analyzeSentimentSettings()
        .setRetrySettings(analyzeSentimentRetrySettingBuilder.build());
    RetrySettings.Builder analyzeEntitiesRetrySettingBuilder =
        clientSettingsBuilder.analyzeEntitiesSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAnalyzeEntitiesInitialRetryDelay() != null) {
      analyzeEntitiesRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAnalyzeEntitiesInitialRetryDelay());
      LOGGER.info(
          "AnalyzeEntitiesInitialRetryDelay set to "
              + this.clientProperties.getAnalyzeEntitiesInitialRetryDelay());
    }
    if (this.clientProperties.getAnalyzeEntitiesRetryDelayMultiplier() != null) {
      analyzeEntitiesRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAnalyzeEntitiesRetryDelayMultiplier());
      LOGGER.info(
          "AnalyzeEntitiesRetryDelayMultiplier set to "
              + this.clientProperties.getAnalyzeEntitiesRetryDelayMultiplier());
    }
    if (this.clientProperties.getAnalyzeEntitiesMaxRetryDelay() != null) {
      analyzeEntitiesRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAnalyzeEntitiesMaxRetryDelay());
      LOGGER.info(
          "AnalyzeEntitiesMaxRetryDelay set to "
              + this.clientProperties.getAnalyzeEntitiesMaxRetryDelay());
    }
    if (this.clientProperties.getAnalyzeEntitiesInitialRpcTimeout() != null) {
      analyzeEntitiesRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAnalyzeEntitiesInitialRpcTimeout());
      LOGGER.info(
          "AnalyzeEntitiesInitialRpcTimeout set to "
              + this.clientProperties.getAnalyzeEntitiesInitialRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeEntitiesRpcTimeoutMultiplier() != null) {
      analyzeEntitiesRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAnalyzeEntitiesRpcTimeoutMultiplier());
      LOGGER.info(
          "AnalyzeEntitiesRpcTimeoutMultiplier set to "
              + this.clientProperties.getAnalyzeEntitiesRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getAnalyzeEntitiesMaxRpcTimeout() != null) {
      analyzeEntitiesRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAnalyzeEntitiesMaxRpcTimeout());
      LOGGER.info(
          "AnalyzeEntitiesMaxRpcTimeout set to "
              + this.clientProperties.getAnalyzeEntitiesMaxRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeEntitiesTotalTimeout() != null) {
      analyzeEntitiesRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAnalyzeEntitiesTotalTimeout());
      LOGGER.info(
          "AnalyzeEntitiesTotalTimeout set to "
              + this.clientProperties.getAnalyzeEntitiesTotalTimeout());
    }
    clientSettingsBuilder
        .analyzeEntitiesSettings()
        .setRetrySettings(analyzeEntitiesRetrySettingBuilder.build());
    RetrySettings.Builder analyzeEntitySentimentRetrySettingBuilder =
        clientSettingsBuilder.analyzeEntitySentimentSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAnalyzeEntitySentimentInitialRetryDelay() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAnalyzeEntitySentimentInitialRetryDelay());
      LOGGER.info(
          "AnalyzeEntitySentimentInitialRetryDelay set to "
              + this.clientProperties.getAnalyzeEntitySentimentInitialRetryDelay());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentRetryDelayMultiplier() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAnalyzeEntitySentimentRetryDelayMultiplier());
      LOGGER.info(
          "AnalyzeEntitySentimentRetryDelayMultiplier set to "
              + this.clientProperties.getAnalyzeEntitySentimentRetryDelayMultiplier());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentMaxRetryDelay() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAnalyzeEntitySentimentMaxRetryDelay());
      LOGGER.info(
          "AnalyzeEntitySentimentMaxRetryDelay set to "
              + this.clientProperties.getAnalyzeEntitySentimentMaxRetryDelay());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentInitialRpcTimeout() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAnalyzeEntitySentimentInitialRpcTimeout());
      LOGGER.info(
          "AnalyzeEntitySentimentInitialRpcTimeout set to "
              + this.clientProperties.getAnalyzeEntitySentimentInitialRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentRpcTimeoutMultiplier() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAnalyzeEntitySentimentRpcTimeoutMultiplier());
      LOGGER.info(
          "AnalyzeEntitySentimentRpcTimeoutMultiplier set to "
              + this.clientProperties.getAnalyzeEntitySentimentRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentMaxRpcTimeout() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAnalyzeEntitySentimentMaxRpcTimeout());
      LOGGER.info(
          "AnalyzeEntitySentimentMaxRpcTimeout set to "
              + this.clientProperties.getAnalyzeEntitySentimentMaxRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeEntitySentimentTotalTimeout() != null) {
      analyzeEntitySentimentRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAnalyzeEntitySentimentTotalTimeout());
      LOGGER.info(
          "AnalyzeEntitySentimentTotalTimeout set to "
              + this.clientProperties.getAnalyzeEntitySentimentTotalTimeout());
    }
    clientSettingsBuilder
        .analyzeEntitySentimentSettings()
        .setRetrySettings(analyzeEntitySentimentRetrySettingBuilder.build());
    RetrySettings.Builder analyzeSyntaxRetrySettingBuilder =
        clientSettingsBuilder.analyzeSyntaxSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAnalyzeSyntaxInitialRetryDelay() != null) {
      analyzeSyntaxRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAnalyzeSyntaxInitialRetryDelay());
      LOGGER.info(
          "AnalyzeSyntaxInitialRetryDelay set to "
              + this.clientProperties.getAnalyzeSyntaxInitialRetryDelay());
    }
    if (this.clientProperties.getAnalyzeSyntaxRetryDelayMultiplier() != null) {
      analyzeSyntaxRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAnalyzeSyntaxRetryDelayMultiplier());
      LOGGER.info(
          "AnalyzeSyntaxRetryDelayMultiplier set to "
              + this.clientProperties.getAnalyzeSyntaxRetryDelayMultiplier());
    }
    if (this.clientProperties.getAnalyzeSyntaxMaxRetryDelay() != null) {
      analyzeSyntaxRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAnalyzeSyntaxMaxRetryDelay());
      LOGGER.info(
          "AnalyzeSyntaxMaxRetryDelay set to "
              + this.clientProperties.getAnalyzeSyntaxMaxRetryDelay());
    }
    if (this.clientProperties.getAnalyzeSyntaxInitialRpcTimeout() != null) {
      analyzeSyntaxRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAnalyzeSyntaxInitialRpcTimeout());
      LOGGER.info(
          "AnalyzeSyntaxInitialRpcTimeout set to "
              + this.clientProperties.getAnalyzeSyntaxInitialRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeSyntaxRpcTimeoutMultiplier() != null) {
      analyzeSyntaxRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAnalyzeSyntaxRpcTimeoutMultiplier());
      LOGGER.info(
          "AnalyzeSyntaxRpcTimeoutMultiplier set to "
              + this.clientProperties.getAnalyzeSyntaxRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getAnalyzeSyntaxMaxRpcTimeout() != null) {
      analyzeSyntaxRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAnalyzeSyntaxMaxRpcTimeout());
      LOGGER.info(
          "AnalyzeSyntaxMaxRpcTimeout set to "
              + this.clientProperties.getAnalyzeSyntaxMaxRpcTimeout());
    }
    if (this.clientProperties.getAnalyzeSyntaxTotalTimeout() != null) {
      analyzeSyntaxRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAnalyzeSyntaxTotalTimeout());
      LOGGER.info(
          "AnalyzeSyntaxTotalTimeout set to "
              + this.clientProperties.getAnalyzeSyntaxTotalTimeout());
    }
    clientSettingsBuilder
        .analyzeSyntaxSettings()
        .setRetrySettings(analyzeSyntaxRetrySettingBuilder.build());
    RetrySettings.Builder classifyTextRetrySettingBuilder =
        clientSettingsBuilder.classifyTextSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getClassifyTextInitialRetryDelay() != null) {
      classifyTextRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getClassifyTextInitialRetryDelay());
      LOGGER.info(
          "ClassifyTextInitialRetryDelay set to "
              + this.clientProperties.getClassifyTextInitialRetryDelay());
    }
    if (this.clientProperties.getClassifyTextRetryDelayMultiplier() != null) {
      classifyTextRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getClassifyTextRetryDelayMultiplier());
      LOGGER.info(
          "ClassifyTextRetryDelayMultiplier set to "
              + this.clientProperties.getClassifyTextRetryDelayMultiplier());
    }
    if (this.clientProperties.getClassifyTextMaxRetryDelay() != null) {
      classifyTextRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getClassifyTextMaxRetryDelay());
      LOGGER.info(
          "ClassifyTextMaxRetryDelay set to "
              + this.clientProperties.getClassifyTextMaxRetryDelay());
    }
    if (this.clientProperties.getClassifyTextInitialRpcTimeout() != null) {
      classifyTextRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getClassifyTextInitialRpcTimeout());
      LOGGER.info(
          "ClassifyTextInitialRpcTimeout set to "
              + this.clientProperties.getClassifyTextInitialRpcTimeout());
    }
    if (this.clientProperties.getClassifyTextRpcTimeoutMultiplier() != null) {
      classifyTextRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getClassifyTextRpcTimeoutMultiplier());
      LOGGER.info(
          "ClassifyTextRpcTimeoutMultiplier set to "
              + this.clientProperties.getClassifyTextRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getClassifyTextMaxRpcTimeout() != null) {
      classifyTextRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getClassifyTextMaxRpcTimeout());
      LOGGER.info(
          "ClassifyTextMaxRpcTimeout set to "
              + this.clientProperties.getClassifyTextMaxRpcTimeout());
    }
    if (this.clientProperties.getClassifyTextTotalTimeout() != null) {
      classifyTextRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getClassifyTextTotalTimeout());
      LOGGER.info(
          "ClassifyTextTotalTimeout set to " + this.clientProperties.getClassifyTextTotalTimeout());
    }
    clientSettingsBuilder
        .classifyTextSettings()
        .setRetrySettings(classifyTextRetrySettingBuilder.build());
    RetrySettings.Builder annotateTextRetrySettingBuilder =
        clientSettingsBuilder.annotateTextSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getAnnotateTextInitialRetryDelay() != null) {
      annotateTextRetrySettingBuilder.setInitialRetryDelay(
          this.clientProperties.getAnnotateTextInitialRetryDelay());
      LOGGER.info(
          "AnnotateTextInitialRetryDelay set to "
              + this.clientProperties.getAnnotateTextInitialRetryDelay());
    }
    if (this.clientProperties.getAnnotateTextRetryDelayMultiplier() != null) {
      annotateTextRetrySettingBuilder.setRetryDelayMultiplier(
          this.clientProperties.getAnnotateTextRetryDelayMultiplier());
      LOGGER.info(
          "AnnotateTextRetryDelayMultiplier set to "
              + this.clientProperties.getAnnotateTextRetryDelayMultiplier());
    }
    if (this.clientProperties.getAnnotateTextMaxRetryDelay() != null) {
      annotateTextRetrySettingBuilder.setMaxRetryDelay(
          this.clientProperties.getAnnotateTextMaxRetryDelay());
      LOGGER.info(
          "AnnotateTextMaxRetryDelay set to "
              + this.clientProperties.getAnnotateTextMaxRetryDelay());
    }
    if (this.clientProperties.getAnnotateTextInitialRpcTimeout() != null) {
      annotateTextRetrySettingBuilder.setInitialRpcTimeout(
          this.clientProperties.getAnnotateTextInitialRpcTimeout());
      LOGGER.info(
          "AnnotateTextInitialRpcTimeout set to "
              + this.clientProperties.getAnnotateTextInitialRpcTimeout());
    }
    if (this.clientProperties.getAnnotateTextRpcTimeoutMultiplier() != null) {
      annotateTextRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getAnnotateTextRpcTimeoutMultiplier());
      LOGGER.info(
          "AnnotateTextRpcTimeoutMultiplier set to "
              + this.clientProperties.getAnnotateTextRpcTimeoutMultiplier());
    }
    if (this.clientProperties.getAnnotateTextMaxRpcTimeout() != null) {
      annotateTextRetrySettingBuilder.setMaxRpcTimeout(
          this.clientProperties.getAnnotateTextMaxRpcTimeout());
      LOGGER.info(
          "AnnotateTextMaxRpcTimeout set to "
              + this.clientProperties.getAnnotateTextMaxRpcTimeout());
    }
    if (this.clientProperties.getAnnotateTextTotalTimeout() != null) {
      annotateTextRetrySettingBuilder.setTotalTimeout(
          this.clientProperties.getAnnotateTextTotalTimeout());
      LOGGER.info(
          "AnnotateTextTotalTimeout set to " + this.clientProperties.getAnnotateTextTotalTimeout());
    }
    clientSettingsBuilder
        .annotateTextSettings()
        .setRetrySettings(annotateTextRetrySettingBuilder.build());
    return LanguageServiceClient.create(clientSettingsBuilder.build());
  }
}
