package app;

import utils.DoublyLinkedList;

import java.io.File;

public class Video {
    private final File file;
    public String title;
    public String description;
    private final String[] tags;

    private static final DoublyLinkedList<Video> videos = new DoublyLinkedList<>();

    private Video(File file, String title, String description, String[] tags) {
        this.file = file;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public static void add(File file, String title, String description, String[] tags) {
        videos.add(new Video(file, title, description, tags));
    }

    public static DoublyLinkedList<Video> getVideos() {
        return videos;
    }

    public static Video getVideo(int index) {
        return videos.get(index);
    }


}
