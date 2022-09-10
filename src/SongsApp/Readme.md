# Date: 9/7/2022
#### Currently working on: Main
### WorkingMethod :
>  CreateALbum
### Implementation in Progress
> AddSongsToAlbum
> (Testing in progress)
### Thoughts:
> There are a lot of method in class MusicApp, Album and Playlist that still haven't been used
> Find implementation for those methods.

# Date: 9/8/2022
### New Field
> ### Class: MusicApp
> listOfPlaylist: arrayList to store the various playlists created by the user
### New methods
> ### Class: MusicApp
> #### CreatePlaylist(Playlist playlist): boolean
> Adds the playlist passes as argument to the arraylist of playlists
> #### PrintAvailablePlaylists(): void
> Prints the previously created playlists
> #### searchForPlaylist(String name): Playlist
> searches for playlist the name of whom matches the argument and returns that playlist, if such a
> playlist doesn't exist, returns null.
> #### removePlaylist(String nameOfPlaylist): int
> uses searchForPlaylist to look for playlist the name of whom matches nameOfPlaylist, removes 
> that playlist and returns the index where the playlist was present at, in the arraylist of playlists, 
> if such a playlist is not found, returns -1
> #### overWriteExistingAlbum(Playlist existing, Playlist newlyCreated): void
> internally uses removePlaylist method to remove the playlist passed as argument to parameter existing 
> and uses the index obtained from removePlaylist to add playlist passed as argument to parameter newlyCreated
> in its place.
> 
> ### Class: Playlist
> #### toString(): String
> prints a playlist as concatenation of its name and number of songs present in it.

# Date: 9/9/2022
### New Methods
> ### Class: Main
> #### removeAlbum(): void
> This method removes an album from the list of available albums, the method first checks if the list of albums is 
> empty, if it is empty, the method prints to the console the corresponding message, if the list of albums is not empty
> the method uses RemoveAlbumFromMemory(String nameOfAlbum): boolean, method which goes through the list of albums and 
> if found removes the album the name of whom matches the argument
> #### removePlaylist():boolean
> this method similar to removeAlbum() method first checks if the list of playlists is empty, if not, uses the 
> removePlaylist(String nameOfPlaylist): int, method to remove the playlist the name of whom matches the argument, if 
> the playlist doesn't exist the method returns false.

# Date: 9/10/22
### New Methods
> ### Class: Main
> #### AddSongsToPlaylist(): void
> checks if the list of playlist is empty, if so outputs the corresponding message to the console, if not asks the user 
> to enter the name of playlist, they wish to add songs to, if the name is correct, asks the user to enter songs name,
> Two things happen at this point, the method first checks is the input is an album's name rather than song's, if so
> adds the entire list of songs from album to the playlist, if the album is empty outputs corresponding message to the 
> console. if the input is not an album's name, the method lookUpForSongThroughAllAlbums is called and the album to which 
> the song belong is searched for, if such an album is found, the AddSongsToPlaylist() method of class Album is used to
> add song to the playlist
> ### Class: MusicApp
> #### lookUpForSongThroughAllAlbums(String nameOfSong): Album
> iterates through the entire album collection, if the album's arraylist of songs is non-empty, iterates through its 
> list of songs checking if any song's title matches the argument, nameOfSong, if so returns the corresponding album, as 
> return value of method, this method is used in class main by method AddSongsToPlaylist

