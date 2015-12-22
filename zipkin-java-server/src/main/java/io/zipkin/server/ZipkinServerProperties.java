/**
 * Copyright 2015 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.zipkin.server;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("zipkin")
class ZipkinServerProperties {
  private Query query = new Query();
  private Store store = new Store();

  public Query getQuery() {
    return this.query;
  }

  public Store getStore() {
    return this.store;
  }

  static class Store {
    enum Type {
      mysql, mem;
    }

    private Type type = Type.mem;

    public Type getType() {
      return this.type;
    }

    public void setType(Type type) {
      this.type = type;
    }
  }

  static class Query {
    private int lookback = 86400000; // 7 days in millis

    public int getLookback() {
      return this.lookback;
    }

    public void setLookback(int lookback) {
      this.lookback = lookback;
    }
  }
}