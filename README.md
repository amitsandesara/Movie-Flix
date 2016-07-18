# Movie-Flix-API

API Requests on TITLE Table
1.	View All Titles: GET  http://localhost:8080/MovieFlix/api/titles/
2.	Find a particular title: GET http://localhost:8080/MovieFlix/api/titles/titleID
3.	Create new Title: POST http://localhost:8080/MovieFlix/api/titles/
Example: {
    "Title": "Forrest Gump",
    "Year": "1994",
    "Rated": "PG-13",
    "Released": "06 Jul 1994",
    "Runtime": "142 min",
    "Genre": "Drama, Romance",
    "Director": "Robert Zemeckis",
    "Writer": "Winston Groom (novel), Eric Roth (screenplay)",
    "Actors": "Tom Hanks, Rebecca Williams, Sally Field, Michael Conner Humphreys",
    "Plot": "Forrest Gump, while not intelligent, has accidentally been present at many historic moments, but his true love, Jenny Curran, eludes him.",
    "Language": "English",
    "Country": "USA",
    "Awards": "Won 6 Oscars. Another 37 wins & 51 nominations.",
    "Poster": "http://ia.media-imdb.com/images/M/MV5BMTI1Nzk1MzQwMV5BMl5BanBnXkFtZTYwODkxOTA5._V1_SX300.jpg",
    "Metascore": "82",
    "imdbRating": "8.8",
    "imdbVotes": "1,167,104",
    "imdbID": "tt0109830",
    "Type": "movie"
  }
4.	Update a title: PUT http://localhost:8080/MovieFlix/api/titles/titleID
5.	Delete a title: DELETE  http://localhost:8080/MovieFlix/api/titles/titleID
6.	Comment on a title: POST http://localhost:8080/MovieFlix/api/titles/postComment
{
    "imdbID": "titleID",
    "Comments": "comment"
}
7.	Get all Comments on a title: GET http://localhost:8080/MovieFlix/api/titles/titleID/viewComments
8.	Rate a title: POST http://localhost:8080/MovieFlix/api/titles/postRating
{
    "imdbID": "titleID",
    "Rating": "rating between 1 and 5"
}
9.	Get average user rating on a title: GET http://localhost:8080/MovieFlix/api/titles/titleID /viewRating
10.	View a title on IMDB: GET http://localhost:8080/MovieFlix/api/titles/titleID /viewOnImdb
11.	View details about the title: GET http://localhost:8080/MovieFlix/api/titles/titleID /getDetails
12.	Search for title: GET http://localhost:8080/MovieFlix/api/titles/search=freeText
13.	View top rated movies and TV series: GET http://localhost:8080/MovieFlix/api/titles/topmovie or http://localhost:8080/MovieFlix/api/titles/topseries
14.	Filter title by Year: GET http://localhost:8080/MovieFlix/api/titles/filter/year=??
15.	Filter title by Genre: GET http://localhost:8080/MovieFlix/api/titles/filter/genre=??
16.	Filter title by Type: GET http://localhost:8080/MovieFlix/api/titles/filter/type=??
17.	Sort by ImdbVotes: GET http://localhost:8080/MovieFlix/api/titles/sortbyvotes
18.	Sort by Year: GET http://localhost:8080/MovieFlix/api/titles/sortbyyear
19.	Sort by ImdbRating: GET http://localhost:8080/MovieFlix/api/titles/sortbyrating




API Requests on Users
1.	View All Users: GET  http://localhost:8080/MovieFlix/api/users/
2.	Find a particular user: GET http://localhost:8080/MovieFlix/api/users/userID
3.	Create new User: POST http://localhost:8080/MovieFlix/api/users/
4.	Update a title: PUT http://localhost:8080/MovieFlix/api/users/userID
5.	Delete a title: DELETE  http://localhost:8080/MovieFlix/api/users/userID



NOTE: Authentication of users is yet to be implemented. All requests on Title table will process without any checking of null data.


