package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import seedu.address.logic.commands.UnfavouriteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.studyspot.Name;

/**
 * Parses input arguments and creates a new UnfavouriteCommand object
 */
public class UnfavouriteCommandParser implements Parser<UnfavouriteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UnfavouriteCommand
     * and returns a UnfavouriteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnfavouriteCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        return new UnfavouriteCommand(name);
    }

}
