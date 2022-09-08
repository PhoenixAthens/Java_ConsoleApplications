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
> 
 

