package com.hippo.ehviewer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import com.hippo.ehviewer.DiskCache;
import com.hippo.ehviewer.ListUrls;
import com.hippo.ehviewer.R;
import com.hippo.ehviewer.view.OlImageView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Util {
    private static String TAG = "Util";
    
    /**
     * Put InputStream to File, default bufferSize is 16 * 1024
     * 
     * @param is
     * @param file
     * @throws IOException 
     */
    public static void inputStream2File(InputStream is, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        copy(is, os);
    }
    
    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[16 * 1024];
        int bytesRead;
        while((bytesRead = is.read(buffer)) !=-1)
            os.write(buffer, 0, bytesRead);
        is.close();
        os.flush();
        os.close();
    }
    
    public static final int BITMAP = 0x0;
    public static final int MOVIE = 0x1;
    
    public static int getResourcesType(String url) {
        int type = BITMAP;
        int index = url.lastIndexOf('.');
        if (index != -1 && url.substring(index + 1).toLowerCase().equals("gif"))
            type = MOVIE;
        return type;
    }
    
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (byte element : b) {
            int v = element & 0xFF;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length()/2*2;
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[(i / 2)] = ((byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16)));
        }
        return data;
    }
    
    public static String InputStream2String(InputStream is) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            String inputLine;
            while ((inputLine = br.readLine()) != null)
                sb.append(inputLine + "\n");
            br.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int length = sb.length();
        if (length != 0)
            sb.delete(length - 1, length);
        return sb.toString();
    }
    
    public static String[] getStrings(SharedPreferences shaper, String key) {
        String str = shaper.getString(key, null);
        if (str == null || str.length() == 0)
            return null;
        return new String(Util.hexStringToByteArray(str)).split("\n");
    }
    
    public static void putStrings(SharedPreferences shaper, String key, List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String item : strs) {
            sb.append(item);
            sb.append('\n');
        }
        int length = sb.length();
        if (length != 0)
            sb.delete(length - 1, length);
        shaper.edit().putString(key, byteArrayToHexString(sb.toString().getBytes())).apply();
    }
}