import type { User } from "./User";

export interface Props {
  user: User;
  onSubmit: (updatedUser: User) => void;
}