package com.example.emptytestprog;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import org.w3c.dom.Text;

class AddTask extends AsyncTask<Void, Void, Void> {

    TextView result;
    Room room;
    Context context;
    ImageView qr;


    public AddTask(TextView result, ImageView qr, Context context){
        this.result = result;
        this.context=context;
        this.qr = qr;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        room = Utils.addRoom();
        Utils.SaveId(room.id, context);
        return null;
    }

    @Override
    protected void onPostExecute(Void param) {
        super.onPostExecute(param);
        result.setText(room.toString());
        String server = "http://vladazavr.pythonanywhere.com/connect/" + room.id + "/" + room.access_code;
        try {
            qr.setImageBitmap(TextToImageEncode(server));
        } catch (WriterException e) {
            e.printStackTrace();
        }
        qr.setVisibility(View.VISIBLE);
    }

    public Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    500, 500, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        context.getResources().getColor(R.color.black):context.getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
