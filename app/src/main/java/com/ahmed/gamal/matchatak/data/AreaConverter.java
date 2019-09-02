package com.ahmed.gamal.matchatak.data;

import androidx.room.TypeConverter;

import com.ahmed.gamal.matchatak.model.Area;

public class AreaConverter {
    @TypeConverter
    public static Area toArea(String value) {
        return value == null ? null : new Area(value);
    }

    @TypeConverter
    public static String areaToString(Area area) {
        return area == null ? null : area.getName();
    }

}
