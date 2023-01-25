export interface EmployeeRequestDto {
  id: number;
  firstName: string;
  lastName: string;
  positionId: number;
  email: string;
  password: string;
}

export class EmployeeLoginDto{
  username: string;
  password: string;
}