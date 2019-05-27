





Feature: editWindow
  As a player
  I want to be able to change the size of the window
  to change the time and difficulty of games.

Scenario: Valid window size
  Given window of width 200 and height 200
  Then window was set

Scenario: Too small window size
  Given window of width 100 and height 100
  Then window wasn't set

Scenario: Too large window size
  Given window of width 500 and height 500
  Then window wasn't set

Scenario: Valid window on large limit
  Given window of width 300 and height 300
  Then window was set

