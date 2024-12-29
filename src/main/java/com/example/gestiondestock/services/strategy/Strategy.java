package com.example.gestiondestock.services.strategy;

import com.flickr4java.flickr.FlickrException;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public interface Strategy<T> {

    T savePhoto(Integer id, InputStream photo, String titre) throws FlickrException, IOException, ExecutionException, InterruptedException;

}
