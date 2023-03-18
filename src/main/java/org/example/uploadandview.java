package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class uploadandview {
    public void options() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Video Management Program!");
        System.out.println("What would you like to do?");
        System.out.println("1. Upload a video");
        System.out.println("2. Retrieve videos by mood");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        switch (choice) {
            case 1:
                uploadVideo(scanner);
                break;
            case 2:
                retrieveVideos(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void uploadVideo(Scanner scanner) {
        System.out.print("Enter your mood (happy, sad, or angry): ");
        String mood = scanner.nextLine();

        File moodFolder = new File("C:\\Users\\RAHUL\\Desktop\\movie recomendation\\movierecomendation\\destination " + mood);
        if (!moodFolder.exists()) {
            boolean success = moodFolder.mkdirs();
            if (!success) {
                System.out.println("Failed to create mood folder.");
                return;
            }
        }

        System.out.print("Enter the path to the video file: ");
        String videoFilePath = scanner.nextLine();
        File videoFile = new File(videoFilePath);
        if (!videoFile.exists()) {
            System.out.println("Video file does not exist.");
            return;
        }

        try {
            Files.copy(videoFile.toPath(), new File(moodFolder, videoFile.getName()).toPath());
            System.out.println("Video uploaded to " + moodFolder.getAbsolutePath() + ".");
        } catch (IOException e) {
            System.out.println("Failed to upload video.");
        }
    }

    private static void retrieveVideos(Scanner scanner) {
        System.out.print("Enter your mood (happy, sad, or angry): ");
        String mood = scanner.nextLine();

        if (mood.equalsIgnoreCase("happy")) {
            File moodFolder = new File("C:\\Users\\RAHUL\\Desktop\\movie recomendation\\movierecomendation\\destination angry");
            if (!moodFolder.exists() || !moodFolder.isDirectory()) {
                System.out.println(mood + "folder does not exist or is not a directory.");                return;
            }

            File[] videoFiles = moodFolder.listFiles();
            if (videoFiles == null || videoFiles.length == 0) {
                System.out.println("No videos found for this mood.");
                return;
            }

            System.out.println("Videos for " + mood + ":");
            for (File videoFile : videoFiles) {
                System.out.println("- " + videoFile.getName());
            }
        }
        if (mood.equalsIgnoreCase("sad")) {
            File moodFolder = new File("C:\\Users\\RAHUL\\Desktop\\movie recomendation\\movierecomendation\\destination sad");
            if (!moodFolder.exists() || !moodFolder.isDirectory()) {
                System.out.println(mood + " folder does not exist or is not a directory.");                return;
            }

            File[] videoFiles = moodFolder.listFiles();
            if (videoFiles == null || videoFiles.length == 0) {
                System.out.println("No videos found for this mood.");
                return;
            }

            System.out.println("Videos for " + mood + ":");
            for (File videoFile : videoFiles) {
                System.out.println("- " + videoFile.getName());
            }
        }
        if (mood.equalsIgnoreCase("angry")) {
            File moodFolder = new File("C:\\Users\\RAHUL\\Desktop\\movie recomendation\\movierecomendation\\destination angry");
            if (!moodFolder.exists() || !moodFolder.isDirectory()) {
                System.out.println(mood + "folder does not exist or is not a directory.");
                return;
            }

            File[] videoFiles = moodFolder.listFiles();
            if (videoFiles == null || videoFiles.length == 0) {
                System.out.println("No videos found for this mood.");
                return;
            }

            System.out.println("Videos for " + mood + ":");
            for (File videoFile : videoFiles) {
                System.out.println("- " + videoFile.getName());
            }
        }
    }
}







