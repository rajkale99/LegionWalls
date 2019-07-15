package org.legion.walls.activities;

import android.support.annotation.NonNull;

import com.dm.wallpaper.board.activities.WallpaperBoardMuzeiActivity;
import org.legion.walls.services.MuzeiService;

public class MuzeiActivity extends WallpaperBoardMuzeiActivity {

    @NonNull
    @Override
    public Class<?> onInit() {
        return MuzeiService.class;
    }
}
