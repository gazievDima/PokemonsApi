# This is Pokemonchiki (:

## Technologies used

-   api https://pokemontcg.io
-   retrofit
-   dagger 2
-   room
-   coroutines
-   navigation component
-   custom view (combine view group)
-   shimmer layout
-   paging
-   glide
-   coordinator
-   view pager

## Release APK
- https://github.com/gazievDima/PokemonsApi/blob/main/pokemonchiki.apk

## Navigation app

```mermaid
graph LR
A[Welcome Fragment] -- button About --> B[About DialogFragment]
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
