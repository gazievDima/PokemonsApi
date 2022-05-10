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
A -- button Pokemons --> C(Pokemons Fragment)
C -- bottom navigation --> D(Favorite Fragment)
D -- bottom navigation --> C
D -- view pager --> L(Latest Fragment)
D -- view pager --> N(Names Fragment)
D -- view pager --> H(Health Fragment)
```


## Screens

![enter image description here](https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg)

![enter image description here](https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg)

![enter image description here](https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg)

![enter image description here](https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg)

![enter image description here](https://github.com/gazievDima/PokemonsApi/blob/main/welcome_1.jpg)
