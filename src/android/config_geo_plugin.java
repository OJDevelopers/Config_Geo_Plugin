/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.developresanddesigners.config_geo_plugin;

import android.*;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.StringTokenizer;

@SuppressLint("SetJavaScriptEnabled")
public class config_geo_plugin extends CordovaPlugin{
	final CallbackContext ContextoRetorno;
    /**
     * Executes the request and returns PluginResult.
     *
     * @param action        The action to execute.
     * @param args          JSONArry of arguments for the plugin.
     * @param callbackId    The callback id used when calling back into JavaScript.
     * @return              A PluginResult object with a status and message.
     */
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        PluginResult.Status status = PluginResult.Status.OK;
		ContextoRetorno = callbackContext;
        String result = "";

        //Information on settings can be found here:
        //http://developer.android.com/reference/android/provider/Settings.html

        if (action.equals("open")) {
            this.cordova.getActivity().startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS),1);
        } else if (action.equals("accessibility")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS));
        } else if (action.equals("add_account")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_ADD_ACCOUNT));
        } else if (action.equals("airplane_mode")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS));
        } else if (action.equals("apn")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_APN_SETTINGS));
        } else if (action.equals("application_details")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS));
        } else if (action.equals("application_development")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
        } else if (action.equals("application")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_SETTINGS));
        }
        else if (action.equals("bluetooth")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS));
        } else if (action.equals("captioning")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_CAPTIONING_SETTINGS));
        } else if (action.equals("cast")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_CAST_SETTINGS));
        } else if (action.equals("data_roaming")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS));
        } else if (action.equals("date")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
        } else if (action.equals("device_info")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS));
        } else if (action.equals("display")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS));
        } else if (action.equals("dream")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_DREAM_SETTINGS));
        } else if (action.equals("home")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_HOME_SETTINGS));
        } else if (action.equals("input_method")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS));
        } else if (action.equals("input_method_subtype")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS));
        } else if (action.equals("internal_storage")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS));
        } else if (action.equals("locale")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS));
        } else if (action.equals("location_source")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        } else if (action.equals("manage_all_applications")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS));
        } else if (action.equals("manage_applications")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS));
        } else if (action.equals("memory_card")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS));
        } else if (action.equals("network_operator")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
        } else if (action.equals("nfcsharing")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_NFCSHARING_SETTINGS));
        } else if (action.equals("nfc_payment")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_NFC_PAYMENT_SETTINGS));
        } else if (action.equals("nfc_settings")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS));
        }
        else if (action.equals("print")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_PRINT_SETTINGS));
        } else if (action.equals("privacy")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_PRIVACY_SETTINGS));
        } else if (action.equals("quick_launch")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_QUICK_LAUNCH_SETTINGS));
        } else if (action.equals("search")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SEARCH_SETTINGS));
        } else if (action.equals("security")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SECURITY_SETTINGS));
        } else if (action.equals("settings")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
        } else if (action.equals("show_regulatory_info")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SHOW_REGULATORY_INFO));
        } else if (action.equals("sound")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS));
        } else if (action.equals("sync")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_SYNC_SETTINGS));
        } else if (action.equals("usage_access")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_USAGE_ACCESS_SETTINGS));
        } else if (action.equals("user_dictionary")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_USER_DICTIONARY_SETTINGS));
        } else if (action.equals("voice_input")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_VOICE_INPUT_SETTINGS));
        } else if (action.equals("wifi_ip")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_WIFI_IP_SETTINGS));
        } else if (action.equals("wifi")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
        } else if (action.equals("wireless")) {
            this.cordova.getActivity().startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        } else {
             status = PluginResult.Status.INVALID_ACTION;
        }
        
        callbackContext.sendPluginResult(new PluginResult(status, result));
        return true;
    }

	protected void onActivityResult(int requestCode, int resultCode,
             Intent data) {
         if (requestCode == 1) {
             if (resultCode == RESULT_OK) {
                 // A contact was picked.  Here we will just display it
                 // to the user.
				 ContextoRetorno.sendPluginResult(new PluginResult("Cerro la Ventana", result));
                 return true;
             }
         }
     }
}