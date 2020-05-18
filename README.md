# java-blackjack

#### 기능 구현 목록

- [x]  플레이어마다 배팅 금액을 정한다.



- [ ]  카드의 숫자를 기본으로 계산한다.
  - [ ] Ace는 1 또는 11로 계산한다.
  - [ ] King, Queen, Jack은 각각 10으로 계산한다.



- [x]  게임에 참여할 사람의 이름을 입력한다.
  - [x] 쉼표 기준으로 이름을 분리한다.



- [ ] 딜러를 포함한 플레이어는 두 장의 카드를 지급 받는다.
  - [ ] 두장의 카드 합이 21일 경우 블랙잭이 된다. 배팅 금액의 1.5배를 딜러에게 받는다.
  - [ ] 딜러와 플레이어가 동시에 블랙잭인 경우 플레이어는 배팅 금액을 돌려받는다.



- [ ]  카드의 합이 21을 넘지 않는 선에서 카드를 계속 뽑을 수 있다.
  - [ ] 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃는다.
  - [ ] 딜러는 카드 합이 16 이하면 반드시 1장의 카드를 추가로 받는다.
  - [ ] 딜러의 카드 합이 17 이상이면 추가로 받지 않는다.



- [ ] 딜러의 카드 합이 21을 초과하면 플레이어들은 패에 상관 없이 승리하여 배팅 금액을 받는다. 
  - [ ] 딜러와 플레이어 중 카드 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 승리한다.