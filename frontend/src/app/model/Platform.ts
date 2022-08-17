import {Developer} from "./Developer";
import {VideoGame} from "./VideoGame";

export interface Platform {
  id: number
  name: string
  releaseDate: Date
  developer?: Developer
  videoGames?: VideoGame[]
}
