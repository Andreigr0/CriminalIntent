package com.andreygritsay.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class PhotoViewFragment extends android.support.v4.app.DialogFragment {
    private final static String KEY_PHOTO = "file";
    private File mPhotoFile;
    private ImageView mPhotoView;

    public static PhotoViewFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_PHOTO, photoFile);
        PhotoViewFragment fragment = new PhotoViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mPhotoFile = (File) getArguments().getSerializable(KEY_PHOTO);
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo_view, null);
        mPhotoView = v.findViewById(R.id.dialog_photo_view);
        Bitmap bitmap = BitmapFactory.decodeFile(mPhotoFile.getPath());
        mPhotoView.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
