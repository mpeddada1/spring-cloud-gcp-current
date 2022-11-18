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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for Identity client bean */
@Generated("by gapic-generator-java")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.showcase.v1beta1.spring.auto.identity")
public class IdentitySpringProperties implements CredentialsSupplier {
  @NestedConfigurationProperty private final Credentials credentials = new Credentials();
  private String quotaProjectId;
  private Integer executorThreadCount;
  private Double createUserRpcTimeoutMultiplier;
  private Duration getUserInitialRetryDelay;
  private Double getUserRetryDelayMultiplier;
  private Duration getUserMaxRetryDelay;
  private Duration getUserInitialRpcTimeout;
  private Double getUserRpcTimeoutMultiplier;
  private Duration getUserMaxRpcTimeout;
  private Duration getUserTotalTimeout;
  private Double updateUserRpcTimeoutMultiplier;
  private Double deleteUserRpcTimeoutMultiplier;
  private Duration listUsersInitialRetryDelay;
  private Double listUsersRetryDelayMultiplier;
  private Duration listUsersMaxRetryDelay;
  private Duration listUsersInitialRpcTimeout;
  private Double listUsersRpcTimeoutMultiplier;
  private Duration listUsersMaxRpcTimeout;
  private Duration listUsersTotalTimeout;

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

  public Double getCreateUserRpcTimeoutMultiplier() {
    return this.createUserRpcTimeoutMultiplier;
  }

  public void setCreateUserRpcTimeoutMultiplier(Double createUserRpcTimeoutMultiplier) {
    this.createUserRpcTimeoutMultiplier = createUserRpcTimeoutMultiplier;
  }

  public Duration getGetUserInitialRetryDelay() {
    return this.getUserInitialRetryDelay;
  }

  public void setGetUserInitialRetryDelay(java.time.Duration getUserInitialRetryDelay) {
    this.getUserInitialRetryDelay = Duration.parse(getUserInitialRetryDelay.toString());
  }

  public Double getGetUserRetryDelayMultiplier() {
    return this.getUserRetryDelayMultiplier;
  }

  public void setGetUserRetryDelayMultiplier(Double getUserRetryDelayMultiplier) {
    this.getUserRetryDelayMultiplier = getUserRetryDelayMultiplier;
  }

  public Duration getGetUserMaxRetryDelay() {
    return this.getUserMaxRetryDelay;
  }

  public void setGetUserMaxRetryDelay(java.time.Duration getUserMaxRetryDelay) {
    this.getUserMaxRetryDelay = Duration.parse(getUserMaxRetryDelay.toString());
  }

  public Duration getGetUserInitialRpcTimeout() {
    return this.getUserInitialRpcTimeout;
  }

  public void setGetUserInitialRpcTimeout(java.time.Duration getUserInitialRpcTimeout) {
    this.getUserInitialRpcTimeout = Duration.parse(getUserInitialRpcTimeout.toString());
  }

  public Double getGetUserRpcTimeoutMultiplier() {
    return this.getUserRpcTimeoutMultiplier;
  }

  public void setGetUserRpcTimeoutMultiplier(Double getUserRpcTimeoutMultiplier) {
    this.getUserRpcTimeoutMultiplier = getUserRpcTimeoutMultiplier;
  }

  public Duration getGetUserMaxRpcTimeout() {
    return this.getUserMaxRpcTimeout;
  }

  public void setGetUserMaxRpcTimeout(java.time.Duration getUserMaxRpcTimeout) {
    this.getUserMaxRpcTimeout = Duration.parse(getUserMaxRpcTimeout.toString());
  }

  public Duration getGetUserTotalTimeout() {
    return this.getUserTotalTimeout;
  }

  public void setGetUserTotalTimeout(java.time.Duration getUserTotalTimeout) {
    this.getUserTotalTimeout = Duration.parse(getUserTotalTimeout.toString());
  }

  public Double getUpdateUserRpcTimeoutMultiplier() {
    return this.updateUserRpcTimeoutMultiplier;
  }

  public void setUpdateUserRpcTimeoutMultiplier(Double updateUserRpcTimeoutMultiplier) {
    this.updateUserRpcTimeoutMultiplier = updateUserRpcTimeoutMultiplier;
  }

  public Double getDeleteUserRpcTimeoutMultiplier() {
    return this.deleteUserRpcTimeoutMultiplier;
  }

  public void setDeleteUserRpcTimeoutMultiplier(Double deleteUserRpcTimeoutMultiplier) {
    this.deleteUserRpcTimeoutMultiplier = deleteUserRpcTimeoutMultiplier;
  }

  public Duration getListUsersInitialRetryDelay() {
    return this.listUsersInitialRetryDelay;
  }

  public void setListUsersInitialRetryDelay(java.time.Duration listUsersInitialRetryDelay) {
    this.listUsersInitialRetryDelay = Duration.parse(listUsersInitialRetryDelay.toString());
  }

  public Double getListUsersRetryDelayMultiplier() {
    return this.listUsersRetryDelayMultiplier;
  }

  public void setListUsersRetryDelayMultiplier(Double listUsersRetryDelayMultiplier) {
    this.listUsersRetryDelayMultiplier = listUsersRetryDelayMultiplier;
  }

  public Duration getListUsersMaxRetryDelay() {
    return this.listUsersMaxRetryDelay;
  }

  public void setListUsersMaxRetryDelay(java.time.Duration listUsersMaxRetryDelay) {
    this.listUsersMaxRetryDelay = Duration.parse(listUsersMaxRetryDelay.toString());
  }

  public Duration getListUsersInitialRpcTimeout() {
    return this.listUsersInitialRpcTimeout;
  }

  public void setListUsersInitialRpcTimeout(java.time.Duration listUsersInitialRpcTimeout) {
    this.listUsersInitialRpcTimeout = Duration.parse(listUsersInitialRpcTimeout.toString());
  }

  public Double getListUsersRpcTimeoutMultiplier() {
    return this.listUsersRpcTimeoutMultiplier;
  }

  public void setListUsersRpcTimeoutMultiplier(Double listUsersRpcTimeoutMultiplier) {
    this.listUsersRpcTimeoutMultiplier = listUsersRpcTimeoutMultiplier;
  }

  public Duration getListUsersMaxRpcTimeout() {
    return this.listUsersMaxRpcTimeout;
  }

  public void setListUsersMaxRpcTimeout(java.time.Duration listUsersMaxRpcTimeout) {
    this.listUsersMaxRpcTimeout = Duration.parse(listUsersMaxRpcTimeout.toString());
  }

  public Duration getListUsersTotalTimeout() {
    return this.listUsersTotalTimeout;
  }

  public void setListUsersTotalTimeout(java.time.Duration listUsersTotalTimeout) {
    this.listUsersTotalTimeout = Duration.parse(listUsersTotalTimeout.toString());
  }
}
