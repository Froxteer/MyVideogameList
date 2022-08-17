import {VideoGame} from "./VideoGame";

export interface Genre {
  id: number
  name: string
  videoGames?: VideoGame[]
}
