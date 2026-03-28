Feature: 电商购物流程
  作为买家，需要登录网站并购买商品
  完成购物流程验证

  Background:
    Given 打开Swag Labs购物网

  @chrome
  Scenario: 正常用户成功登录并加购商品
    Given 输入用户名:"standard"，输入密码:"standard"
    When 点击登录按钮
    Then 应该登录成功

    When 点击购买:"Sauce Labs Backpack"
    Then 购物车数量显示为:1

    When 点击购买:"Sauce Labs Bike Light"
    Then 购物车数量显示为:2

    When 点击购物车图标
    Then 购物车中的商品及其价格应该是
      | itemName              | itemPrice  |
      | Sauce Labs Backpack   | $29.99     |
      | Sauce Labs Bike Light | $9.99      |

  @edge
  Scenario Outline: 使用不同账号登录并验证权限

    Given 输入用户名:"<username>"，输入密码:"<password>"
    When 点击登录按钮
    Then 应该看到:"<expected>"

    Examples:
      | username      | password | expected          |
      | standard      | standard | 登录成功           |
      | locked        | locked   | 用户被锁定         |
      | fake          | fake     | 用户名或密码不正确  |

