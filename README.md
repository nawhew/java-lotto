# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기
### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능 목록
- 구분자를 가지는 문자열을 분리하여 각 숫자의 합을 반환
    - 쉼표(,) 또는 콜론(:)을 구분자로 가진다
    - 문자열의 길이가 0이거나 null인 경우 0을 반환한다
    - 숫자가 하나인 경우 해당 숫자를 반환한다
    - 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
- 커스텀 구분자를 추가 할 수 있다.
    - 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

## 로또
### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 목록
- 로또를 발급한다
    - 번호는 1부터 46사이의 수를 가진다.
    - 발급 할 번호의 크기의 기본값은 총 6개이다.
    - 번호는 모두 자동으로 발급한다.
        - 번호는 세팅된 46개 중에서 임의로 섞은 6개를 가지고 온다.
        - 번호는 사용자가 미리 원하는 수만 세팅 할 수 있다. 
- 구입금액을 입력받으면 금액에 맞는 만큼 로또를 발급한다.
    - 입력받은 금액의 단위는 원이다.
    - 로또는 한장에 1000원이다.
    - 발급 된 로또는 작은수부터 출력한다
        - 예: [1, 2, 3, 4, 5, 6]
- 발급 후 지난 주 당첨 번호를 입력하여 통계를 출력한다.
    - 당첨 번호의 구분자는 콤마(,)로 한다.
    - 3개 일치부터 당첨금이 생긴다.
    - 당첨의 경우 별로 결과를 출력한다.
        - 번호가 3 ~ 6개 일치한 경우
    - 당첨금에 맞는 수익률을 계산하여 출력한다.
- 2등을 위한 보너스 번호를 하나 더 뽑는다
    - 보너스 번호는 당첨 번호 입력 후 입력한다.
    - 보너스 번호는 1개이다.
    - 기존의 당첨번호 중 5개와 보너스번호를 맞추면 2등이다.