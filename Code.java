package javaProject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.ArrayList;

public class JavaGUIMusicPlayerJFrame extends JFrame implements ActionListener {

    private JTextField filePathField;
    private JButton playButton;
    private JButton pauseButton;
    private JButton chooseButton;
    private JButton loopButton;
    private JButton nextButton;
    private JButton prevButton;
    private boolean isPaused;
    private boolean isLooping = false;
    private JFileChooser fileChooser;
    private Clip clip;
    private ArrayList<File> playlist;
    private int currentSongIndex;

    public JavaGUIMusicPlayerJFrame() {
        super("Music Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        filePathField = new JTextField(20);
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        chooseButton = new JButton("Choose File");
        loopButton = new JButton("Loop");
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");

        isPaused = false;
        isLooping = false;
        playlist = new ArrayList<>();
        currentSongIndex = -1;

        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        chooseButton.addActionListener(this);
        loopButton.addActionListener(this);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);

        add(filePathField);
        add(chooseButton);
        add(playButton);
        add(pauseButton);
        add(loopButton);
        add(nextButton);
        add(prevButton);

        fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileNameExtensionFilter("WAV Files", "wav"));

        setSize(500, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == playButton) {
            playMusic();
        } else if (event.getSource() == pauseButton) {
            pauseMusic();
        } else if (event.getSource() == chooseButton) {
            chooseFile();
        } else if (event.getSource() == loopButton) {
            toggleLoop();
        } else if (event.getSource() == nextButton) {
            playNextSong();
        } else if (event.getSource() == prevButton) {
            playPreviousSong();
        }
    }

    private void playMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        try {
            File file = new File(filePathField.getText());
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            if (isLooping) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void pauseMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPaused = true;
            pauseButton.setText("Resume");
        } else if (clip != null && isPaused) {
            clip.start();
            if (isLooping) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            isPaused = false;
            pauseButton.setText("Pause");
        }
    }

    private void chooseFile() {
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                playlist.add(file);
            }

            if (playlist.size() == selectedFiles.length && currentSongIndex == -1) {
                currentSongIndex = 0;
                filePathField.setText(playlist.get(currentSongIndex).getAbsolutePath());
                playMusic();
            }
        }
    }

    private void toggleLoop() {
        isLooping = !isLooping;
        if (isLooping) {
            loopButton.setText("Stop Loop");
            if (clip.isRunning()) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } else {
            loopButton.setText("Loop");
            if (clip.isRunning()) {
                clip.loop(0);
            }
        }
    }

    private void playNextSong() {
        if (!playlist.isEmpty()) {
            currentSongIndex++;
            if (currentSongIndex >= 0 && currentSongIndex < playlist.size()) {
                File nextFile = playlist.get(currentSongIndex);
                filePathField.setText(nextFile.getAbsolutePath());
                playMusic();
            } else {
                currentSongIndex = playlist.size() - 1;
            }
        }
    }

    private void playPreviousSong() {
        if (!playlist.isEmpty()) {
            currentSongIndex--;
            if (currentSongIndex >= 0 && currentSongIndex < playlist.size()) {
                File prevFile = playlist.get(currentSongIndex);
                filePathField.setText(prevFile.getAbsolutePath());
                playMusic();
            } else {
                currentSongIndex = 0;
            }
        }
    }

    public static void main(String[] args) {
        new JavaGUIMusicPlayerJFrame();
    }
}
