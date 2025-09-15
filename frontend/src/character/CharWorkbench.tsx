import { useEffect, useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { useLocation } from "react-router-dom";
import { Flex, Tabs } from "@mantine/core";
import { getCharacterById } from "@/api/character_api";
import CharPage from "@/character/CharPage";

function CharWorkbench() {
  const [activeTab, setActiveTab] = useState<string | null>(null);
  const location = useLocation();
  const arrayFromState: number[] = location.state ? location.state : [];

  // Sort the array for deterministic TanStack query cache.
  const sortedChars = [...arrayFromState].sort((a, b) => a - b);

  const query = useQuery({
    queryKey: ["character-batch", sortedChars],
    queryFn: () => getCharacterById(sortedChars),
  });

  useEffect(() => {
    if (query.data && query.data.length > 0 && !activeTab) {
      setActiveTab(query.data[0].characterName);
    }
  }, [query]);

  if (query.isLoading) {
    return <div>Loading...</div>;
  }

  // character objects are passed
  return (
    <>
      <Flex justify="flex-start">
        <Tabs
          variant="outline"
          defaultValue="DefaultValue"
          value={activeTab}
          onChange={setActiveTab}
        >
          <Tabs.List>
            {query.data?.map((char) => (
              <Tabs.Tab key={`charWorkbenchTab-${char.characterId}`} value={char.characterName}>
                {char.characterName}
              </Tabs.Tab>
            ))}
          </Tabs.List>

          {query.data?.map((char) => (
            <Tabs.Panel key={`charWorkbenchPanel-${char.characterId}`} value={char.characterName}>
              <CharPage key={`charPage-${char.characterId}`} character={char} />
            </Tabs.Panel>
          ))}
        </Tabs>
      </Flex>
    </>
  );
}

export default CharWorkbench;
