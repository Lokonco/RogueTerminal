# Java RPG — Workshop Project

A text-based RPG built in Java to demonstrate core Object-Oriented Programming concepts. You explore a grid map, fight random enemies, and hunt down the final boss.

---

## How to Run

1. Clone or download the project
2. Open in your IDE (IntelliJ / VS Code)
3. Run `Main.java`

---

## Project Structure

```
src/
├── Main.java
├── GameCharacters/
│   ├── Character.java       # Abstract base class for all living things
│   ├── Player.java          # The hero (extends Character)
│   ├── Enemy.java           # Standard enemy (extends Character)
│   ├── BossEnemy.java       # Boss with damage resistance (extends Enemy)
│   └── EnemyFactory.java    # Creates enemies — random or boss
├── Map/
│   ├── GameMap.java         # 6x6 grid of tiles + player position
│   └── Biomes/
│       ├── Tile.java        # Abstract base class for all tiles
│       ├── PlainTile.java   # Safe tile, nothing happens
│       ├── ForestTile.java  # 30% chance of a random battle
│       ├── CaveTile.java    # Boss battle + end of game
│       └── ShopTile.java    # (Bonus) Buy potions and upgrades
└── GameLogic/
    ├── Game.java            # Main menu and game loop
    ├── Battle.java          # Turn-based combat (static utility)
    └── CaveAnimation.java   # (Bonus) Animated cave tunnel effect
```

---

## Class Breakdown

### GameCharacters

**`Character`** — The abstract foundation every living thing is built on. Holds the shared fields (`name`, `Health`, `AttackDamage`) and shared behaviour (`takeDamage()`, `isAlive()`). Cannot be instantiated directly.

**`Player`** — Extends `Character`. Represents the human's in-game avatar. Adds `gold`, `potions`, and a `maxHealth` cap. Handles healing and potion usage.

**`Enemy`** — Extends `Character`. Represents a standard foe. Adds a `goldReward` field that gets paid out to the player on defeat.

**`BossEnemy`** — Extends `Enemy`. Overrides `takeDamage()` to halve all incoming damage before passing it up to the parent. Everything else is inherited from `Enemy`.

**`EnemyFactory`** — A static factory class. The only place in the project where enemy objects are created. Keeps enemy construction logic in one place so adding new enemies only ever requires editing this file.

---

### Map

**`GameMap`** — Owns the 6x6 `Tile[][]` grid and the player's current `x` / `y` coordinates. Handles movement with edge-wrapping via the `%` operator.

**`Tile`** — Abstract base class for every map tile. Defines the contract: every tile must have a `name` and implement `onEnter(Player)`.

**`PlainTile`** — The safest tile. `onEnter()` just prints a quiet message — no events, no battles.

**`ForestTile`** — Has a 30% chance of triggering a random enemy encounter each time the player steps on it. Uses `EnemyFactory` to generate the enemy and `Battle` to run the fight.

**`CaveTile`** — The final tile. Gives the player a choice to enter, then triggers the boss battle. Winning here ends the game with a victory.

**`ShopTile`** *(Bonus)* — Lets the player spend gold on potions or a weapon upgrade via a looping shop menu. Requires two small additions to `Player` and one to `Character` to work.

---

### GameLogic

**`Game`** — The orchestrator. Runs the main menu, handles player creation, and drives the game loop. Every turn it gets the current tile and calls `onEnter()` on it.

**`Battle`** — A static utility class that runs a complete turn-based fight between a `Player` and an `Enemy`. Returns `true` if the player won, `false` if they lost.

**`CaveAnimation`** *(Bonus)* — Plays a procedural ASCII cave tunnel animation using `Thread.sleep()` and random wall shifts. Purely visual — called before the boss fight.

---

## OOP Concepts Used

| Concept | Where |
|---|---|
| **Abstraction** | `Character` and `Tile` are abstract — they define a contract for all subclasses |
| **Inheritance** | `Player` and `Enemy` extend `Character`. All tiles extend `Tile` |
| **Polymorphism** | `Battle` accepts any `Enemy` — Java picks the right `takeDamage()` at runtime |
| **Encapsulation** | `Player` fields like `gold` and `potions` are private, accessed through methods only |
| **Factory Pattern** | `EnemyFactory` is the only place enemies are created |

---

## How the Map Works

The map is a 6x6 grid (`Tile[][]`). Two integers — `x` and `y` — track the player's position. Moving updates one of those values by 1. The `%` operator wraps the edges so the player never falls off.

```
     [0]      [1]      [2]      [3]      [4]      [5]
[0] Forest   Plain   Forest  Forest  Forest   CAVE
[1] Forest  Forest  Forest  Forest  Forest  Forest
...
```

The player starts at `(0, 0)`. The Cave is at `(5, 0)`.

---

## How a Battle Works

1. Player and enemy stats are printed
2. Player chooses **Attack** or **Use Potion**
3. If the enemy survives, it attacks back
4. Loop repeats until one side reaches 0 HP
5. `Battle.startBattle()` returns `true` (win) or `false` (loss)
