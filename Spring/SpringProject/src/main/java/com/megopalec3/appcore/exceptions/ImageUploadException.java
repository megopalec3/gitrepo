package com.megopalec3.appcore.exceptions;

import java.io.IOException;

public class ImageUploadException extends IOException {

    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(String message, IOException cause) {
        super(message, cause);
    }
}
