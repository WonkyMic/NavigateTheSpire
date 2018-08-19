package cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;
import powers.AutoPlayFormPower;
import powers.AutoPlayFormUpgradePower;

public class AutoPlayForm extends CustomCard {
	public static final String ID = "AutoPlayForm";
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = "Auto Play Form";
    public static final String DESCRIPTION = "Auto play the cards in your hand.";
    public static final String IMG_PATH = "img/cards/autoplay.png";
    public static final String UPGRADED_DESCRIPTION = "Auto play the cards in your hand, but this card is upgraded.";
    private static final int COST = 0;
    
    public AutoPlayForm() {
		super (ID, NAME, IMG_PATH, COST, DESCRIPTION,
				AbstractCard.CardType.POWER, AbstractCard.CardColor.COLORLESS,
				AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
		this.magicNumber = this.baseMagicNumber = 1;
    }
    
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		if (this.upgraded){
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new AutoPlayFormUpgradePower(p, this.magicNumber), this.magicNumber));
		}
		else {
			AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new AutoPlayFormPower(p, this.magicNumber), this.magicNumber));
		}
	}
	
	@Override
	public AbstractCard makeCopy() {
		return new AutoPlayForm();
	}
	
	@Override
	public void upgrade() {
		if (!this.upgraded) {
			this.upgradeName();
			this.rawDescription = UPGRADED_DESCRIPTION;
			this.initializeDescription();
		}
	}

}
