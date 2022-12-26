package app;

import utils.DoublyLinkedList;

import java.io.*;

public class Video implements Serializable {
    public static final long serialVersionUID = 1634406154074148213L;
    private final File file;

    private final File cover;

    public String title;

    public String description;

    private final String[] tags;

    private static final DoublyLinkedList<Video> videos = new DoublyLinkedList<>();

    private Video(File file, File cover, String title, String description, String[] tags) {
        this.file = file;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.tags = tags;

    }

    public File getFile() {
        return file;
    }

    public String[] getTags() {
        return tags;
    }

    public File getCover() {
        return cover;
    }

    private static void serializeObject(Video video) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream("temp/" + video.title + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(video);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error while serializing video");
        }
    }

    public static void add(File file, File cover, String title, String description, String[] tags) {
        Video video = new Video(file, cover, title, description, tags);
        try {
            serializeObject(video);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        videos.add(video);

    }

    public static DoublyLinkedList<Video> getVideos() {
        return videos;
    }

    public static Video getVideo(int index) {
        return videos.get(index);
    }

    public int searchTag(String targetTag) {
        // TODO: Trying Binray Search
        int score = 0;
        for (String tag : tags) {
            if (tag.equals(targetTag))
                score++;
        }
        return score;
    }


}
