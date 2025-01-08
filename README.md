# Song Management System in Java

## Overview

The Song Management System is a music streaming application built in Java, similar to popular platforms like Spotify. The project demonstrates core functionalities of a music player, including playback control (play, pause, stop), playlist management, and song navigation. The system supports the addition of songs to a playlist and allows users to interact with music files through a user-friendly interface.

## Features

- **Playback Control**: Users can play, pause, and stop songs.
- **Playlist Management**: Users can create and manage playlists, including adding, removing, and reordering songs.
- **Navigation**: The system supports navigation through the playlist with the options to play the next or previous song.
- **Loop Functionality**: Toggle the loop mode to replay the current song continuously.
- **File Selection**: Users can choose songs from their local file system to play.
- **Error Handling**: Graceful handling of invalid file inputs or operation errors.

## Technologies Used

- **Java**: The primary programming language used to build the application.
- **Swing**: For building the graphical user interface (GUI).
- **javax.sound.sampled**: For handling audio playback.

## How It Works

- The application allows users to interact with songs via a GUI with buttons for playing, pausing, and controlling playback.
- Users can select songs from their local file system using a file chooser.
- The system keeps track of the playlist and allows for navigation between songs.
- The "Loop" button toggles looping functionality, and songs can be repeated continuously.

## Project Structure

- **JavaGUIMusicPlayerJFrame.java**: Contains the main logic for the application, implementing the GUI and audio playback features.
- **Playlist Management**: Uses an `ArrayList` to store and manage the playlist, allowing users to add and remove songs.

## How to Run

1. Clone the repository or download the source code.
2. Compile the Java files using your IDE or a terminal.
3. Run the `JavaGUIMusicPlayerJFrame` class.
4. Use the GUI to load songs, play them, manage playlists, and navigate through the song list.

## Sample User Interface

- **Play Button**: Starts playing the song.
- **Pause Button**: Pauses the song, and changes to "Resume" when paused.
- **Choose File Button**: Opens a file chooser to select songs.
- **Loop Button**: Toggles between looping the current song or not.
- **Next Button**: Plays the next song in the playlist.
- **Previous Button**: Plays the previous song in the playlist.

## Future Enhancements

- User authentication (login functionality).
- Integration with online music databases (e.g., to fetch song metadata).
- Advanced features like shuffle, repeat, and creating custom playlists.
- Implementing song recommendation algorithms.
- Support for other file formats (e.g., MP3, FLAC).

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements

- Inspired by music streaming platforms like Spotify.
- Uses Java Swing for building the GUI and javax.sound.sampled for audio handling.
