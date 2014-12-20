package net.mike.other;

import java.util.*;

/**
 * Created by doliu on 12/9/14.
 */
public class StraightFlush {
	private static final int SF_COUNT = 5;
	private static final int ACE = 1;
	private static final int ACE_LAST = 14;

	public boolean hasStraightFlush(List<PokerCard> cards) {
		if (cards == null || cards.size() < SF_COUNT) return false;
		Map<Integer, List<Integer>> suitToRanks = getSuitToRanks(cards);
		for (Map.Entry<Integer, List<Integer>> entry : suitToRanks.entrySet()) {
			List<Integer> ranks = entry.getValue();
			if (ranks.size() < SF_COUNT) continue;
			for (int i = 0; i <= ranks.size() - SF_COUNT; i++) {
				int rank = ranks.get(i);
				int endIndex = i + (SF_COUNT - 1);
				if ((ranks.get(endIndex) - rank) == (SF_COUNT - 1)) {
					return true;
				}
			}
		}
		return false;
	}

	private Map<Integer, List<Integer>> getSuitToRanks(List<PokerCard> cards) {
		Map<Integer, Set<Integer>> suitToRanks  = new HashMap<>();
		for (PokerCard card : cards) {
			int suit = card.suit, rank = card.rank;
			if (suitToRanks.containsKey(suit)) {
				suitToRanks.get(suit).add(rank);
				if (rank == ACE)
					suitToRanks.get(suit).add(ACE_LAST);
			} else {
				Set<Integer> ranks = new HashSet<>();
				ranks.add(rank);
				if (rank == ACE)
					suitToRanks.get(suit).add(ACE_LAST);
				suitToRanks.put(suit, ranks);
			}
		}
		Map<Integer, List<Integer>> result = new HashMap<>();
		for (Map.Entry<Integer, Set<Integer>> entry : suitToRanks.entrySet()) {
			int suit = entry.getKey();
			Set<Integer> ranks = entry.getValue();
			List<Integer> rankList = new ArrayList<>();
			rankList.addAll(ranks);
			Collections.sort(rankList);
			result.put(suit, rankList);
		}
		return result;
	}

	private static class PokerCard {
		public int rank;
		public int suit;
	}
}
