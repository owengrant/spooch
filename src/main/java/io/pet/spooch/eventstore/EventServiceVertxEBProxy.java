/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package io.pet.spooch.eventstore;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceException;
import io.vertx.serviceproxy.ServiceExceptionMessageCodec;
/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/

@SuppressWarnings({"unchecked", "rawtypes"})
public class EventServiceVertxEBProxy implements EventService {
  private Vertx _vertx;
  private String _address;
  private DeliveryOptions _options;
  private boolean closed;

  public EventServiceVertxEBProxy(Vertx vertx, String address) {
    this(vertx, address, null);
  }

  public EventServiceVertxEBProxy(Vertx vertx, String address, DeliveryOptions options) {
    this._vertx = vertx;
    this._address = address;
    this._options = options;
    try{
      this._vertx.eventBus().registerDefaultCodec(ServiceException.class, new ServiceExceptionMessageCodec());
    } catch (IllegalStateException ex) {}
  }

  @Override
  public  void publish(JsonObject data, Handler<AsyncResult<Void>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("data", data);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "publish");
    _vertx.eventBus().<Void>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void poll(int eventId, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("eventId", eventId);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "poll");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void pollEvent(int eventId, String event, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("eventId", eventId);
    _json.put("event", event);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "pollEvent");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void pollEntity(int eventId, String entity, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("eventId", eventId);
    _json.put("entity", entity);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "pollEntity");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void pollEntityEvent(int eventId, String entity, String event, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("eventId", eventId);
    _json.put("entity", entity);
    _json.put("event", event);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "pollEntityEvent");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void pollEntityById(int entityId, String entity, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("entityId", entityId);
    _json.put("entity", entity);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "pollEntityById");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void findLastEvent(int entityId, String entity, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("entityId", entityId);
    _json.put("entity", entity);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "findLastEvent");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
  @Override
  public  void find(String hash, Handler<AsyncResult<JsonArray>> complete){
    if (closed) {
      complete.handle(Future.failedFuture(new IllegalStateException("Proxy is closed")));
      return;
    }
    JsonObject _json = new JsonObject();
    _json.put("hash", hash);

    DeliveryOptions _deliveryOptions = (_options != null) ? new DeliveryOptions(_options) : new DeliveryOptions();
    _deliveryOptions.addHeader("action", "find");
    _vertx.eventBus().<JsonArray>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        complete.handle(Future.failedFuture(res.cause()));
      } else {
        complete.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }
}
