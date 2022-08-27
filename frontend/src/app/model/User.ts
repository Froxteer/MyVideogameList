import {VideoGameUser} from "./VideoGameUser";

export interface User {
  id?: number
  email: string
  username: string
  password: string
  videoGameUsers?: VideoGameUser[]
}
