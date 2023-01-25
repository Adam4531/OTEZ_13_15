export class ClientRequestDto {
  email: string;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  address: string;
  createdTime: Date;
  password: string;
  NIP: string;
  nameOfCompany: string;

  constructor(email: string, firstName: string, lastName: string, password: string){
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password;
  }
}