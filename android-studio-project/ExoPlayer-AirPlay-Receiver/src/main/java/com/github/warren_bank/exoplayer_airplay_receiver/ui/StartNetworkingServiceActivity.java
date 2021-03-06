package com.github.warren_bank.exoplayer_airplay_receiver.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.warren_bank.exoplayer_airplay_receiver.R;
import com.github.warren_bank.exoplayer_airplay_receiver.MainApp;
import com.github.warren_bank.exoplayer_airplay_receiver.service.NetworkingService;
import com.github.warren_bank.exoplayer_airplay_receiver.utils.NetworkUtils;

public class StartNetworkingServiceActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (!NetworkUtils.isWifiConnected(MainApp.getInstance())) {
      finish();
      return;
    }

    setContentView(R.layout.activity_start_networking_service);
    startListenService();
    onBackPressed();
  }

  private void startListenService() {
    Intent intent = new Intent(getApplicationContext(), NetworkingService.class);
    MainApp.getInstance().startService(intent);
    finish();
  }
}
