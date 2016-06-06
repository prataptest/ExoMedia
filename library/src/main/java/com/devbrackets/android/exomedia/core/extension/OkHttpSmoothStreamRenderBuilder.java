package com.devbrackets.android.exomedia.core.extension;

import android.content.Context;
import com.devbrackets.android.exomedia.core.builder.SmoothStreamRenderBuilder;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.TransferListener;
import okhttp3.OkHttpClient;

public class OkHttpSmoothStreamRenderBuilder extends SmoothStreamRenderBuilder {
  private final OkHttpClient okHttpClient;

  public OkHttpSmoothStreamRenderBuilder(Context context, String userAgent, String url,
      OkHttpClient okHttpClient) {
    super(context, userAgent, url);
    this.okHttpClient = okHttpClient;
  }

  public OkHttpSmoothStreamRenderBuilder(Context context, String userAgent, String url,
      int streamType, OkHttpClient okHttpClient) {
    super(context, userAgent, url, streamType);
    this.okHttpClient = okHttpClient;
  }

  @Override
  protected DataSource createDataSource(Context context, TransferListener transferListener,
      String userAgent) {
    return new OkHttpDataSource(okHttpClient, userAgent, null, transferListener);
  }

}
