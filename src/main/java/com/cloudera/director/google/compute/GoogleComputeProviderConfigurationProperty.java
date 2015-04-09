/*
 * Copyright (c) 2015 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.director.google.compute;

import com.cloudera.director.spi.v1.model.ConfigurationProperty;

import java.util.Locale;

public enum GoogleComputeProviderConfigurationProperty implements ConfigurationProperty {

  /**
   * A GCE zone to target for deployment of instances.
   * <p/>
   * Example: "us-central1-a"
   *
   * TODO(duftler): Feels a bit off to specify this on the compute provider, but it's not really a property of the
   * instance template either. Revisit this.
   */
  ZONE("zone", true, "", "Zone to target for deployment");

  private final String configKey;
  private final boolean required;
  private final String defaultValue;
  private final String description;

  private GoogleComputeProviderConfigurationProperty(String configKey, boolean required,
                                                     String defaultValue, String description) {
    this.configKey = configKey;
    this.required = required;
    this.defaultValue = defaultValue;
    this.description = description;
  }

  @Override
  public String getConfigKey() {
    return configKey;
  }

  @Override
  public boolean isRequired() {
    return required;
  }

  @Override
  public String getDefaultValue() {
    return defaultValue;
  }

  @Override
  public String getDescription(Locale locale) {
    return description;
  }

  @Override
  public String getMissingValueErrorMessage() {
    return null;
  }

  @Override
  public boolean isSensitive() {
    return false;
  }
}
