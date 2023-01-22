/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.35.1025 on 2023-01-22 19:04:31.

export interface EventDto {
    id: number;
    typeOfEventEntity: TypeOfEventEntity;
    price: number;
    payment: PaymentEntity;
    headEmployee: EmployeeEntity;
    dateStart: Date;
    dateEnd: Date;
    status: StatusEnum;
    client: ClientEntity;
}

export interface IntermediaryCompanyEditRequestDto {
    name_of_company: string;
}

export interface IntermediaryCompanyRequestDto {
    NIP: string;
    name_of_company: string;
    type_Of_Service_id: number;
}

export interface IntermediaryCompanyResponseDto {
    NIP: string;
    name_of_company: string;
    type_Of_Service_id: number;
}

export interface PaymentDto {
}

export interface TicketDto {
    id: number;
    client: ClientEntity;
    pricePerUnit: number;
    event: EventEntity;
}

export interface TicketEditRequestDto {
    price_per_unit: number;
}

export interface TicketRequestDto {
    id: number;
    client_id: number;
    price_per_unit: number;
    event_id: number;
}

export interface ClientEditRequestDto {
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    address: string;
    password: string;
    NIP: string;
    nameOfCompany: string;
}

export interface ClientLoginDto {
    email: string;
    password: string;
}

export interface ClientLoginResponseDto extends Serializable {
    sessionId: string;
    errorsListDto: ErrorsListDto;
}

export interface ClientRequestDto {
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    address: string;
    createdTime: Date;
    password: string;
    NIP: string;
    nameOfCompany: string;
}

export interface ClientResponseDto {
    email: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    address: string;
    password: string;
    createdTime: Date;
    NIP: string;
    nameOfCompany: string;
}

export interface EmployeeLoginDto {
    email: string;
    password: string;
}

export interface EmployeeLoginResponseDto extends Serializable {
    sessionId: string;
    errorsListDto: ErrorsListDto;
}

export interface EmployeeRequestDto {
    id: number;
    firstName: string;
    lastName: string;
    positionId: number;
    email: string;
    password: string;
}

export interface TypeOfEventEntity {
    id: number;
    name: string;
}

export interface PaymentEntity {
    id: number;
    price: number;
    client: ClientEntity;
    dateOfPayment: Date;
}

export interface EmployeeEntity extends SuperEntity {
    firstName: string;
    lastName: string;
    position: PositionEntity;
    email: EmailValidator;
    password: string;
}

export interface ClientEntity extends SuperEntity {
    email: EmailValidator;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    address: string;
    password: string;
    createdTime: Date;
    nameOfCompany: string;
    nip: string;
}

export interface EventEntity {
    id: number;
    price: number;
    payment: PaymentEntity;
    headEmployee: EmployeeEntity;
    dateStart: Date;
    dateEnd: Date;
    status: StatusEnum;
    client: ClientEntity;
    typeOfEvent: TypeOfEventEntity;
}

export interface ErrorsListDto {
    errors: string[];
    fieldName: string;
    listOfErrorsEmpty: boolean;
}

export interface Serializable {
}

export interface PositionEntity {
    id: number;
    position: string;
}

export interface EmailValidator extends Validator {
}

export interface SuperEntity {
    id: number;
}

export interface Validator {
}

export const enum StatusEnum {
    CANCELLED = "CANCELLED",
    IN_PROGRESS = "IN_PROGRESS",
}
