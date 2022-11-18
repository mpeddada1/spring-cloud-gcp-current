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
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for Testing client bean */
@Generated("by gapic-generator-java")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.showcase.v1beta1.spring.auto.testing")
public class TestingSpringProperties implements CredentialsSupplier {
  @NestedConfigurationProperty private final Credentials credentials = new Credentials();
  private String quotaProjectId;
  private Integer executorThreadCount;
  private Double createSessionRpcTimeoutMultiplier;
  private Double getSessionRpcTimeoutMultiplier;
  private Double listSessionsRpcTimeoutMultiplier;
  private Double deleteSessionRpcTimeoutMultiplier;
  private Double reportSessionRpcTimeoutMultiplier;
  private Double listTestsRpcTimeoutMultiplier;
  private Double deleteTestRpcTimeoutMultiplier;
  private Double verifyTestRpcTimeoutMultiplier;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Double getCreateSessionRpcTimeoutMultiplier() {
    return this.createSessionRpcTimeoutMultiplier;
  }

  public void setCreateSessionRpcTimeoutMultiplier(Double createSessionRpcTimeoutMultiplier) {
    this.createSessionRpcTimeoutMultiplier = createSessionRpcTimeoutMultiplier;
  }

  public Double getGetSessionRpcTimeoutMultiplier() {
    return this.getSessionRpcTimeoutMultiplier;
  }

  public void setGetSessionRpcTimeoutMultiplier(Double getSessionRpcTimeoutMultiplier) {
    this.getSessionRpcTimeoutMultiplier = getSessionRpcTimeoutMultiplier;
  }

  public Double getListSessionsRpcTimeoutMultiplier() {
    return this.listSessionsRpcTimeoutMultiplier;
  }

  public void setListSessionsRpcTimeoutMultiplier(Double listSessionsRpcTimeoutMultiplier) {
    this.listSessionsRpcTimeoutMultiplier = listSessionsRpcTimeoutMultiplier;
  }

  public Double getDeleteSessionRpcTimeoutMultiplier() {
    return this.deleteSessionRpcTimeoutMultiplier;
  }

  public void setDeleteSessionRpcTimeoutMultiplier(Double deleteSessionRpcTimeoutMultiplier) {
    this.deleteSessionRpcTimeoutMultiplier = deleteSessionRpcTimeoutMultiplier;
  }

  public Double getReportSessionRpcTimeoutMultiplier() {
    return this.reportSessionRpcTimeoutMultiplier;
  }

  public void setReportSessionRpcTimeoutMultiplier(Double reportSessionRpcTimeoutMultiplier) {
    this.reportSessionRpcTimeoutMultiplier = reportSessionRpcTimeoutMultiplier;
  }

  public Double getListTestsRpcTimeoutMultiplier() {
    return this.listTestsRpcTimeoutMultiplier;
  }

  public void setListTestsRpcTimeoutMultiplier(Double listTestsRpcTimeoutMultiplier) {
    this.listTestsRpcTimeoutMultiplier = listTestsRpcTimeoutMultiplier;
  }

  public Double getDeleteTestRpcTimeoutMultiplier() {
    return this.deleteTestRpcTimeoutMultiplier;
  }

  public void setDeleteTestRpcTimeoutMultiplier(Double deleteTestRpcTimeoutMultiplier) {
    this.deleteTestRpcTimeoutMultiplier = deleteTestRpcTimeoutMultiplier;
  }

  public Double getVerifyTestRpcTimeoutMultiplier() {
    return this.verifyTestRpcTimeoutMultiplier;
  }

  public void setVerifyTestRpcTimeoutMultiplier(Double verifyTestRpcTimeoutMultiplier) {
    this.verifyTestRpcTimeoutMultiplier = verifyTestRpcTimeoutMultiplier;
  }
}
