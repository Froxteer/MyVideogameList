import {Platform} from "./Platform";
import {VideoGame} from "./VideoGame";

export interface Developer {
  id: number
  name: string
  foundationDate: Date
  localization: string
  platforms?: Platform[]
  videoGames?: VideoGame[]
}
