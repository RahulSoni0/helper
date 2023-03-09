package com.squareup.picasso;

import android.content.Context;
import com.itextpdf.text.Annotation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

class ContentStreamRequestHandler extends RequestHandler {
    final Context context;

    ContentStreamRequestHandler(Context context2) {
        this.context = context2;
    }

    public boolean canHandleRequest(Request request) {
        return Annotation.CONTENT.equals(request.uri.getScheme());
    }

    public RequestHandler.Result load(Request request, int i) throws IOException {
        return new RequestHandler.Result(Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK);
    }

    /* access modifiers changed from: package-private */
    public InputStream getInputStream(Request request) throws FileNotFoundException {
        return this.context.getContentResolver().openInputStream(request.uri);
    }
}
