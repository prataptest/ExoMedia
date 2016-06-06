package com.devbrackets.android.exomedia.core.extension;

import android.content.Context;
import com.devbrackets.android.exomedia.core.builder.DashRenderBuilder;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.TransferListener;
import com.google.android.exoplayer.upstream.UriDataSource;
import okhttp3.OkHttpClient;

public class OkHttpDashRenderBuilder extends DashRenderBuilder {
  private final OkHttpClient okHttpClient;
  public OkHttpDashRenderBuilder(Context context, String userAgent, String url,
      OkHttpClient okHttpClient) {
    super(context, userAgent, url);
    this.okHttpClient = okHttpClient;
  }

  public OkHttpDashRenderBuilder(Context context, String userAgent, String url, int streamType,
      OkHttpClient okHttpClient) {
    super(context, userAgent, url, streamType);
    this.okHttpClient = okHttpClient;
  }

  @Override
  protected UriDataSource createManifestDataSource(Context context, String userAgent) {
    return new OkHttpDataSource(okHttpClient, userAgent, null);
  }

  @Override
  protected DataSource createDataSource(Context context, TransferListener transferListener,
      String userAgent) {
    return new OkHttpDataSource(okHttpClient, userAgent, null, transferListener);
  }
}
