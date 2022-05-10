# This is Pokemonchiki (:

## Technologies used

-   shimmer layout
-   dagger 2
-   room
-   paging
-   glide
-   retrofit
-   coroutines
-   coordinator
-   view pager
-   navigation component

## Release APK
- https://github.com/gazievDima/apk-release.apk

## Navigation app

```mermaid
graph LR
A[Welcome Fragment] -- button About --> B[About Fragment]
A -- button Gallery --> C(Pokemons Fragment)
C -- bottom navigation --> D(Favorite Fragment)
D -- bottom navigation --> C
D -- view pager --> L(Latest Fragment)
D -- view pager --> N(Names Fragment)
D -- view pager --> H(Health Fragment)
```


## Screens

<img src="https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg" width="300" height="600" />
<img src="https://github.com/gazievDima/PokemonsApi/blob/main/welcome_0.jpg" width="300" height="600" />
<img src="https://github.com/gazievDima/PokemonsApi/blob/main/welcome_2.jpg" width="300" height="600" />
<img src="https://github.com/gazievDima/PokemonsApi/blob/main/welcome_3.jpg" width="300" height="600" />
<img src="https://github.com/gazievDima/PokemonsApi/blob/main/welcome_4.jpg" width="300" height="600" />
