/*
 * Copyright 2020 Hushub, IDKjava, ATOM Thailand, Neostar, BokChoy [TH]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.astrobee.qruco.astrobee;

import android.graphics.Bitmap;
import android.util.Log;

import co.astrobee.qruco.BinaryBitmap;
import co.astrobee.qruco.LuminanceSource;
import co.astrobee.qruco.RGBLuminanceSource;
import co.astrobee.qruco.common.HybridBinarizer;

public class Astrobee{

  public BinaryBitmap BitmapConvert(final Bitmap bMap) {
    int[] intArray = new int[bMap.getWidth() * bMap.getHeight()];
    Log.i("QrucoLib", "[Bitmap] int Array bitmap complete.");
    bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());
    Log.i("QrucoLib", "[Bitmap] GetPixel complete.");
    LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
    Log.i("QrucoLib", "[Bitmap] new LuminanceSource complete.");
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    Log.i("QrucoLib", "[Bitmap] Binnary Bitmap has build complete.");
    //BinaryBitmap bitmap = Bbitmap.crop(100,50,1280,960);
    return bitmap;
  }

  public double ConvertStringToDouble(String data, String type){
      String Data = data.replaceAll(type + ", " ,"");
      Log.i("QrucoLib", "[ConvertStringToDouble] convert" + type + "to double complete.");
      return Double.valueOf(Data);
  }

  public double Calculate_QuaW (double QX, double QY, double QZ){
    /*double Process_1 = QX*QY;
    Log.i("QrucoLib", "[Calculate Qua_W] Process 1 (QX*QY) = " + Process_1);
    double Process_2 = Math.sqrt(QZ);
    Log.i("QrucoLib", "[Calculate Qua_W] Process 2 (sqrt.QZ) = " + Process_2);
    double Process_3 = Process_1*Process_2;
    Log.i("QrucoLib", "[Calculate Qua_W] Process 3 (QX*QY*sqrt.QZ)= " + Process_3);
    double Process_4 = Process_3-3;
    Log.i("QrucoLib", "[Calculate Qua_W] Process 4 (Process_3 - 3)= " + Process_4);
    double Process_5 = Math.pow(Process_4, 2);
    Log.i("QrucoLib", "[Calculate Qua_W] Process 5 (Process_4 pow.2) " + Process_5);
    //double Data = Math.pow((QX * QY * Math.sqrt(QZ)) -3,2);
    return Process_5;*/
    return Math.pow((QX * QY * Math.sqrt(QZ)) -3,2);
  }
}
