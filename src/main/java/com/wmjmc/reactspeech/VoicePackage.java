package com.wmjmc.reactspeech;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by JMC on 14/01/2016.
 */
public class VoicePackage implements ReactPackage {

    private final Activity mMainActivity;
    private VoiceModule mModuleInstance;

    public VoicePackage(Activity mainActivity) {
        this.mMainActivity = mainActivity;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> modules = new ArrayList<>();

        this.mModuleInstance = new VoiceModule(reactApplicationContext, this.mMainActivity); 
        modules.add(this.mModuleInstance);

        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public void handleActivityResult(final int requestCode, final int resultCode, final Intent data) {
      if (this.mModuleInstance == null) {
          return;
      }

      this.mModuleInstance.onActivityResult(requestCode, resultCode, data);
    }

}
