/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;

/**
 *
 * @author Anala
 */
public class Spooch {
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        var entry = new Gateway();
        var vertx = Vertx.vertx();

        var url = Spooch.class.getClassLoader().getResource("config/config.json");
        var sConfig = Files.readAllLines(Paths.get(url.toURI()))
                            .stream().reduce("", (t,c) -> t.concat(c));
        var config = new JsonObject(sConfig);
        vertx.deployVerticle(entry, new DeploymentOptions().setConfig(config));
    }
}
