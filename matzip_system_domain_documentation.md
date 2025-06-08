# 도메인 모델 문서

## 개요
이 문서는 MatZip 시스템의 도메인 엔티티와 그들 간의 관계를 설명합니다. MatZip은 음식점/장소 관리 및 공유 플랫폼으로 보입니다.

## 핵심 도메인

### 사용자 관리

#### User (사용자)
시스템 사용자를 나타내는 중심 엔티티로, 포괄적인 인증 및 프로필 관리 기능을 제공합니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| userId | int | PK | 고유 식별자 |
| username | string | UK | 사용자가 선택한 사용자명 |
| email | string | UK | 사용자 이메일 주소 |
| password | string | | 암호화된 비밀번호 |
| phoneNumber | string | | 연락처 전화번호 |
| fullName | string | | 사용자 실명 |
| isActive | boolean | | 계정 활성 상태 플래그 |
| lastLoginAt | datetime | | 마지막 로그인 시간 |
| emailVerifiedAt | datetime | | 이메일 인증 완료 시간 |
| emailVerificationToken | string | | 이메일 인증용 토큰 |
| passwordResetToken | string | | 비밀번호 재설정 토큰 |
| passwordResetExpiredAt | datetime | | 비밀번호 재설정 토큰 만료일 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### UserHistory (사용자 이력)
감사 및 롤백 목적을 위한 사용자 데이터 변경 이력을 기록합니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| userHistoryId | int | PK | 고유 식별자 |
| userId | int | FK | User 참조 |
| username | string | | 이력 시점의 사용자명 |
| email | string | | 이력 시점의 이메일 |
| password | string | | 이력 시점의 비밀번호 |
| phoneNumber | string | | 이력 시점의 전화번호 |
| fullName | string | | 이력 시점의 실명 |
| isActive | boolean | | 이력 시점의 활성 상태 |
| lastLoginAt | datetime | | 이력 시점의 마지막 로그인 시간 |
| emailVerifiedAt | datetime | | 이력 시점의 이메일 인증 시간 |
| emailVerificationToken | string | | 이력 시점의 이메일 인증 토큰 |
| passwordResetToken | string | | 이력 시점의 비밀번호 재설정 토큰 |
| passwordResetExpiredAt | datetime | | 이력 시점의 토큰 만료일 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### LoginHistory (로그인 이력)
사용자 인증 시도 및 세션에 대한 포괄적인 로깅을 제공합니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| loginHistoryId | int | PK | 고유 식별자 |
| userId | int | FK | User 참조 |
| loginTime | datetime | | 세션 시작 시간 |
| logoutTime | datetime | | 세션 종료 시간 |
| ipAddress | string | | 클라이언트 IP 주소 |
| userAgent | string | | 브라우저/클라이언트 정보 |
| loginStatus | string | | 성공/실패 상태 |
| failureReason | string | | 실패 시 실패 사유 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

### 장소 관리

#### MatZip (맛집)
사용자가 추가하고 관리할 수 있는 음식점이나 장소를 나타내는 핵심 엔티티입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| matZipId | int | PK | 고유 식별자 |
| name | string | | 음식점/장소명 |
| address | string | | 물리적 주소 |
| description | string | | 추가 상세정보 또는 메모 |
| addedUserId | int | FK | 이 장소를 추가한 사용자 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### Tag (태그)
사용자가 맞춤 라벨로 MatZip 장소를 정리할 수 있는 분류 시스템입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| tagId | int | PK | 고유 식별자 |
| tagName | string | | 태그 표시명 |
| color | string | | 시각적 색상 식별자 |
| createdUserId | int | FK | 이 태그를 생성한 사용자 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### MatZipTag (맛집 태그)
MatZip 장소와 Tag를 연결하는 다대다 관계 테이블입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| matZipId | int | FK | MatZip 참조 |
| tagId | int | FK | Tag 참조 |
| addedUserId | int | FK | 이 태그를 적용한 사용자 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

### 리스트 관리

#### MatZipList (맛집 리스트)
정리 및 공유를 위해 사용자가 생성한 MatZip 장소 모음입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| listId | int | PK | 고유 식별자 |
| listName | string | | 리스트 표시명 |
| description | string | | 리스트 설명 또는 목적 |
| ownerId | int | FK | 이 리스트를 소유한 사용자 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### MatZipListItem (맛집 리스트 항목)
어떤 MatZip 장소가 어떤 리스트에 속하는지 정의하는 다대다 관계 테이블입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| listId | int | FK | MatZipList 참조 |
| matZipId | int | FK | MatZip 참조 |
| addedUserId | int | FK | 이 항목을 리스트에 추가한 사용자 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

#### MatZipListHistory (맛집 리스트 이력)
특정 변경 유형 추적을 포함한 MatZipList 변경사항의 감사 추적 기록입니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| listHistoryId | int | PK | 고유 식별자 |
| listId | int | FK | MatZipList 참조 |
| listName | string | | 이력 시점의 리스트명 |
| description | string | | 이력 시점의 설명 |
| ownerId | int | | 이력 시점의 소유자 ID |
| ownershipTransferredBy | int | | 소유권을 이전한 사용자 (해당시) |
| changeType | string | 제한값 | 변경 유형 (INFO_UPDATED, OWNERSHIP_TRANSFERRED, LIST_CREATED만 허용) |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

### 공유 및 협업

#### MatZipListShare (맛집 리스트 공유)
세분화된 접근 제어를 통해 사용자 간 MatZipList 공유 권한을 관리합니다.

| 필드명 | 타입 | 제약조건 | 설명 |
|--------|------|----------|------|
| shareId | int | PK | 고유 식별자 |
| listId | int | FK | 공유된 MatZipList 참조 |
| sharedUserId | int | FK | 접근 권한을 받은 사용자 |
| sharedByUserId | int | FK | 접근 권한을 부여한 사용자 |
| canEditListInfo | boolean | | 리스트 메타데이터 수정 권한 |
| canEditListItems | boolean | | 항목 추가/제거 권한 |
| canEditSharedUsers | boolean | | 공유 설정 관리 권한 |
| sharedAt | datetime | | 공유가 부여된 시간 |
| createdBy | int | | 생성자 |
| createdAt | datetime | | 생성일시 |
| updatedBy | int | | 수정자 |
| updatedAt | datetime | | 수정일시 |

## 도메인 관계

### 사용자 중심 관계
- **User → MatZip**: 사용자가 여러 장소를 추가할 수 있는 일대다 관계
- **User → MatZipList**: 사용자가 여러 리스트를 소유할 수 있는 일대다 관계
- **User → Tag**: 사용자가 맞춤 태그를 생성할 수 있는 일대다 관계
- **User → UserHistory**: 감사 추적을 위한 일대다 관계
- **User → LoginHistory**: 세션 추적을 위한 일대다 관계

### 컨텐츠 정리 관계
- **MatZip → MatZipTag**: MatZipTag 중간 테이블을 통한 다대다 관계
- **Tag → MatZipTag**: MatZipTag 중간 테이블을 통한 다대다 관계
- **MatZipList → MatZipListItem**: 리스트 내용을 위한 일대다 관계
- **MatZip → MatZipListItem**: 각 장소가 어떤 리스트에 포함되는지 보여주는 일대다 관계

### 공유 및 협업 관계
- **MatZipList → MatZipListShare**: 공유 권한을 위한 일대다 관계
- **User → MatZipListShare**: 공유자와 피공유자로서의 다대다 관계
- **MatZipList → MatZipListHistory**: 변경 추적을 위한 일대다 관계

### 감사 및 이력 관계
- **User → UserHistory**: 사용자 데이터의 이력 스냅샷
- **MatZipList → MatZipListHistory**: 특정 변경 유형을 가진 변경 추적
- **User → LoginHistory**: 인증 및 세션 감사 추적

## 주요 설계 패턴

### 감사 추적 패턴
대부분의 엔티티는 포괄적인 감사 필드(`createdBy`, `createdAt`, `updatedBy`, `updatedAt`)를 포함하며, 일부는 변경 추적을 위한 전용 이력 테이블을 가집니다.

### 소프트 참조 패턴
이력 테이블은 외래 키만이 아닌 참조된 데이터의 복사본(예: MatZipListHistory의 `ownerId`)을 저장하여, 참조된 엔티티가 변경되어도 컨텍스트를 보존합니다.

### 세분화된 권한 패턴
MatZipListShare 엔티티는 다양한 유형의 접근에 대해 별도의 플래그를 가진 세밀한 권한 제어를 보여줍니다.

### 사용자 귀속 패턴
많은 작업들이 특정 사용자에게 귀속되어(다양한 엔티티의 `addedUserId`와 같이) 명확한 소유권과 책임 연쇄를 유지합니다.
