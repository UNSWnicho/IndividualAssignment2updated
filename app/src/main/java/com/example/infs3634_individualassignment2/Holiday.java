package com.example.infs3634_individualassignment2;

    import android.content.Context;
    import android.content.Intent;
    import android.graphics.drawable.Drawable;
    import android.media.Image;

    import java.io.Serializable;
    import java.util.ArrayList;


public class Holiday implements Serializable {
    private String id;
    private String name;
    private String location;
    private String time_zone;
    private String rating;
    private String description;
    private String image;
    private String map;

    public Holiday(String name, String location, String time_zone, String rating, String description, String image, String map ) {
        this.name = name;
        this.location = location;
        this.time_zone = time_zone;
        this.rating = rating;
        this.description = description;
        this.image = image;
        this.image = map;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public static int getImage(Context context, String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }

    public static ArrayList<Holiday> getHolidays() {
        ArrayList<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Playbutton", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        holidays.add(new Holiday("Sample", "Sample", "Sample", "Sample", "Sample", "Sample", "Sample"));
        return holidays;
        int resource = getImage(activity, Holiday.getImage());
        Drawable drawable = getResources().getDrawable(resource);
    }

    Intent detailsIntent = new Intent(Holiday.this, DetailActivity.class);
    detailsIntent.putExtra("SongObject", Holiday();
    // Starts intent
    startActivity(detailsIntent);

    public static Holiday findHolidays(String id) {
        ArrayList<Holiday> holidays = Holiday.getHolidays();
        for(Holiday holiday : holidays) {
            if(holiday.getId().equals(id)) {
                return holiday;
            }
        }
        return null;
    }
}