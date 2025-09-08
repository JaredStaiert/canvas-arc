import { useState } from 'react';
import { Flex, Tabs } from '@mantine/core';
import CharPage from "@/character/CharPage";

function CharWorkbench() {
  const [activeTab, setActiveTab] = useState<string | null>('characterName');

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
            <Tabs.Tab value="characterName">CharacterName</Tabs.Tab>
          </Tabs.List>

          <Tabs.Panel value="characterName">
            <CharPage />
          </Tabs.Panel>
        </Tabs>
      </Flex>
    </>
  );
}

export default CharWorkbench;
