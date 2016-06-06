package com.devbrackets.android.exomedia.core.extension;

import android.content.Context;
import com.devbrackets.android.exomedia.core.builder.RenderBuilder;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.TransferListener;
import okhttp3.OkHttpClient;

public class OkHttpDefaultRendererBuilder extends RenderBuilder {
  private final OkHttpClient okHttpClient;

  public OkHttpDefaultRendererBuilder(Context context, String userAgent, String uri,
      OkHttpClient okHttpClient) {
    super(context, userAgent, uri);
    this.okHttpClient = okHttpClient;
  }

  public OkHttpDefaultRendererBuilder(Context context, String userAgent, String uri, int streamType,
      OkHttpClient okHttpClient) {
    super(context, userAgent, uri, streamType);
    this.okHttpClient = okHttpClient;
  }

  @Override
  protected DataSource createDataSource(Context context, TransferListener transferListener,
      String userAgent) {
    return new OkHttpDataSource(okHttpClient, userAgent, null, transferListener);
  }
}
