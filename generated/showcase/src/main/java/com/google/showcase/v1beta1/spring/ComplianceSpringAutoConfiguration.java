/*
 * Copyright 2022 Google LLC
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

package com.google.showcase.v1beta1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.showcase.v1beta1.ComplianceClient;
import com.google.showcase.v1beta1.ComplianceSettings;
import java.io.IOException;
import java.util.Collections;
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
 * Auto-configuration for {@link ComplianceClient}.
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
@ConditionalOnClass(ComplianceClient.class)
@ConditionalOnProperty(
    value = "com.google.showcase.v1beta1.spring.auto.compliance.enabled",
    matchIfMissing = false)
@EnableConfigurationProperties(ComplianceSpringProperties.class)
public class ComplianceSpringAutoConfiguration {
  private final ComplianceSpringProperties clientProperties;
  private static final Log LOGGER = LogFactory.getLog(ComplianceSpringAutoConfig.class);

  protected ComplianceSpringAutoConfiguration(ComplianceSpringProperties clientProperties) {
    this.clientProperties = clientProperties;
  }

  /**
   * Obtains the default credentials provider. The used key will be obtained from Spring Boot
   * configuration data files.
   */
  @Bean
  @ConditionalOnMissingBean
  public CredentialsProvider complianceCredentials() throws IOException {
    return ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultComplianceTransportChannelProvider() {
    return ComplianceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a ComplianceClient bean configured to use the default credentials provider (obtained
   * with complianceCredentials()) and its default transport channel provider
   * (defaultComplianceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Individual retry settings are configured as well. It will use the relevant client library's
   * default retry settings when they are not specified in ComplianceProperties.
   */
  @Bean
  @ConditionalOnMissingBean
  public ComplianceClient complianceClient(
      @Qualifier("complianceCredentials") CredentialsProvider credentialsProvider,
      @Qualifier("defaultComplianceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    ComplianceSettings.Builder clientSettingsBuilder =
        ComplianceSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider)
            .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      LOGGER.info(
          "Quota project id set to "
              + this.clientProperties.getQuotaProjectId()
              + ", this overrides project id from credentials.");
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          ComplianceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      LOGGER.info(
          "Background executor thread count is " + this.clientProperties.getExecutorThreadCount());
    }
    RetrySettings.Builder repeatDataBodyRetrySettingBuilder =
        clientSettingsBuilder.repeatDataBodySettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataBodyRpcTimeoutMultiplier() != null) {
      repeatDataBodyRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataBodyRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataBodyRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataBodyRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataBodySettings()
        .setRetrySettings(repeatDataBodyRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataBodyInfoRetrySettingBuilder =
        clientSettingsBuilder.repeatDataBodyInfoSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataBodyInfoRpcTimeoutMultiplier() != null) {
      repeatDataBodyInfoRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataBodyInfoRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataBodyInfoRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataBodyInfoRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataBodyInfoSettings()
        .setRetrySettings(repeatDataBodyInfoRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataQueryRetrySettingBuilder =
        clientSettingsBuilder.repeatDataQuerySettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataQueryRpcTimeoutMultiplier() != null) {
      repeatDataQueryRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataQueryRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataQueryRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataQueryRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataQuerySettings()
        .setRetrySettings(repeatDataQueryRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataSimplePathRetrySettingBuilder =
        clientSettingsBuilder.repeatDataSimplePathSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataSimplePathRpcTimeoutMultiplier() != null) {
      repeatDataSimplePathRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataSimplePathRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataSimplePathRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataSimplePathRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataSimplePathSettings()
        .setRetrySettings(repeatDataSimplePathRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataPathResourceRetrySettingBuilder =
        clientSettingsBuilder.repeatDataPathResourceSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataPathResourceRpcTimeoutMultiplier() != null) {
      repeatDataPathResourceRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataPathResourceRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataPathResourceRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataPathResourceRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataPathResourceSettings()
        .setRetrySettings(repeatDataPathResourceRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataPathTrailingResourceRetrySettingBuilder =
        clientSettingsBuilder
            .repeatDataPathTrailingResourceSettings()
            .getRetrySettings()
            .toBuilder();
    if (this.clientProperties.getRepeatDataPathTrailingResourceRpcTimeoutMultiplier() != null) {
      repeatDataPathTrailingResourceRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataPathTrailingResourceRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataPathTrailingResourceRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataPathTrailingResourceRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataPathTrailingResourceSettings()
        .setRetrySettings(repeatDataPathTrailingResourceRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataBodyPutRetrySettingBuilder =
        clientSettingsBuilder.repeatDataBodyPutSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataBodyPutRpcTimeoutMultiplier() != null) {
      repeatDataBodyPutRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataBodyPutRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataBodyPutRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataBodyPutRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataBodyPutSettings()
        .setRetrySettings(repeatDataBodyPutRetrySettingBuilder.build());
    RetrySettings.Builder repeatDataBodyPatchRetrySettingBuilder =
        clientSettingsBuilder.repeatDataBodyPatchSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getRepeatDataBodyPatchRpcTimeoutMultiplier() != null) {
      repeatDataBodyPatchRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getRepeatDataBodyPatchRpcTimeoutMultiplier());
      LOGGER.info(
          "RepeatDataBodyPatchRpcTimeoutMultiplier set to "
              + this.clientProperties.getRepeatDataBodyPatchRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .repeatDataBodyPatchSettings()
        .setRetrySettings(repeatDataBodyPatchRetrySettingBuilder.build());
    RetrySettings.Builder getEnumRetrySettingBuilder =
        clientSettingsBuilder.getEnumSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getGetEnumRpcTimeoutMultiplier() != null) {
      getEnumRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getGetEnumRpcTimeoutMultiplier());
      LOGGER.info(
          "GetEnumRpcTimeoutMultiplier set to "
              + this.clientProperties.getGetEnumRpcTimeoutMultiplier());
    }
    clientSettingsBuilder.getEnumSettings().setRetrySettings(getEnumRetrySettingBuilder.build());
    RetrySettings.Builder verifyEnumRetrySettingBuilder =
        clientSettingsBuilder.verifyEnumSettings().getRetrySettings().toBuilder();
    if (this.clientProperties.getVerifyEnumRpcTimeoutMultiplier() != null) {
      verifyEnumRetrySettingBuilder.setRpcTimeoutMultiplier(
          this.clientProperties.getVerifyEnumRpcTimeoutMultiplier());
      LOGGER.info(
          "VerifyEnumRpcTimeoutMultiplier set to "
              + this.clientProperties.getVerifyEnumRpcTimeoutMultiplier());
    }
    clientSettingsBuilder
        .verifyEnumSettings()
        .setRetrySettings(verifyEnumRetrySettingBuilder.build());
    return ComplianceClient.create(clientSettingsBuilder.build());
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-compliance";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
